package com.boll6.steel.dao.impl;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.boll6.steel.dao.IBaseDao;

@Repository
@SuppressWarnings("unchecked")
@Transactional
public class BaseDaoImpl<T> implements IBaseDao<T> {

	private Class<?> _entityClass = null;

	protected Class<?> getEntityClass() {
		if (_entityClass == null) {
			Class<?> cl = getClass();
			java.lang.reflect.Type superType = cl.getGenericSuperclass();
			if (superType instanceof ParameterizedType) {
				java.lang.reflect.Type paramTypes[] = ((ParameterizedType) superType).getActualTypeArguments();
				if (paramTypes.length > 0)
					_entityClass = (Class<?>) paramTypes[0];
			}
		}
		return _entityClass;
	}

	@Autowired 
	private SessionFactory sessionFactory;

	/**
	 * 获得当前事物的session
	 * 
	 * @return org.hibernate.Session
	 */
	public Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	
	public Serializable save(T o) {
		if (o != null) { 
			o = invokeNewObj(o);
			return this.getCurrentSession().save(o);
		}
		return null;
	}

	
	public T get(Class<T> c, Serializable id) {
		return (T) this.getCurrentSession().get(c, id);
	}

	
	public T get(String hql) {
		Query q = this.getCurrentSession().createQuery(hql);
        List<T> l = q.list();
		if ((l != null) && (l.size() > 0)) {
			return l.get(0);
		}
		return null;
	}

	
	public T get(String hql, Map<String, Object> params) {
		Query q = this.getCurrentSession().createQuery(hql);
		if ((params != null) && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		List<T> l = q.list();
		if ((l != null) && (l.size() > 0)) {
			return l.get(0);
		}
		return null;
	}

	
	public void delete(T o) {
		if (o != null) {
			o = invokeDelObj(o);
			this.getCurrentSession().update(o);
		}
	}
	public void deleted(T o) {
		if (o != null) { 
			this.getCurrentSession().delete(o);
		}
	}
	
	public void update(T o) {
		if (o != null) {
			o = invokeUpdObj(o);
			this.getCurrentSession().update(o);
		}
	}

	
	public void saveOrUpdate(T o) {
		if (o != null) {
			o =invokeUpdObj(o);
			this.getCurrentSession().saveOrUpdate(o);
		}
	}

	
	public List<T> find(String hql) {
		Query q = this.getCurrentSession().createQuery(hql);
		return q.list();
	}

	
	public List<T> find(String hql, Map<String, Object> params) {
		Query q = this.getCurrentSession().createQuery(hql);
		if ((params != null) && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.list();
	}

	
	public List<T> find(String hql, Map<String, Object> params, int page, int rows) {
		Query q = this.getCurrentSession().createQuery(hql);
		if ((params != null) && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	
	public List<T> find(String hql, int page, int rows) {
		Query q = this.getCurrentSession().createQuery(hql);
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	
	public Long count(String hql) {
		Query q = this.getCurrentSession().createQuery(hql);
		return (Long) q.uniqueResult();
	}

	
	public Long count(String hql, Map<String, Object> params) {
		Query q = this.getCurrentSession().createQuery(hql);
		if ((params != null) && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return (Long) q.uniqueResult();
	}

	
	public int executeHql(String hql) {
		Query q = this.getCurrentSession().createQuery(hql);
		return q.executeUpdate();
	}

	
	public int executeHql(String hql, Map<String, Object> params) {
		Query q = this.getCurrentSession().createQuery(hql);
		if ((params != null) && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.executeUpdate();
	}

	
	public List<Object[]> findBySql(String sql) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		return q.list();
	}

	
	public List<Object[]> findBySql(String sql, int page, int rows) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	
	public List<Object[]> findBySql(String sql, Map<String, Object> params) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql).addEntity(getEntityClass());
		if ((params != null) && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.list();
	}

	
	public List<?> findEntityBySql(String sql, Map<String, Object> params,Class<?> entityClass) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		if ((params != null) && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
//		q.setResultTransformer(Transformers.aliasToBean(entityClass));

//		q.setResultTransformer(new AliasToBeanResultTransformer(entityClass));
		q.addEntity(entityClass);
		return q.list();
	}
	
	public List<?> findVoBySql(String sql, Map<String, Object> params,Class<?> entityClass) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		if ((params != null) && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		q.setResultTransformer(Transformers.aliasToBean(entityClass));
 
		return q.list();
	}
	
    public List<Object[]> findBySql(String sql, Map<String, Object> params, int page, int rows) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		if ((params != null) && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	
	public int executeSql(String sql) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		return q.executeUpdate();
	}

	
	public int executeSql(String sql, Map<String, Object> params) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		if ((params != null) && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.executeUpdate();
	}

	
	public BigInteger countBySql(String sql) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		return (BigInteger) q.uniqueResult();
	}

	
	public BigInteger countBySql(String sql, Map<String, Object> params) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		if ((params != null) && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return (BigInteger) q.uniqueResult();
	}
	
	public BigDecimal countBySqlBigDecimal(String sql, Map<String, Object> params) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		if ((params != null) && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return  (BigDecimal) q.uniqueResult();
	}

	private T invokeNewObj(T o) {
		try {
			Method[] methods = o.getClass().getDeclaredMethods();
			for (Method method : methods) {
				if ("setState".equals(method.getName())) {
					method.invoke(o, 1);
				}
				if ("setCreateDate".equals(method.getName())) {
					method.invoke(o, new Date());
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} 
		return o;
	}

	private T invokeDelObj(T o) {
		try {
			Method[] methods = o.getClass().getDeclaredMethods();
			for (Method method : methods) { 
				if ("setState".equals(method.getName())) {
					method.invoke(o, 0);
				} 
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	private T invokeUpdObj(T o) {
		try {
			Method[] methods = o.getClass().getDeclaredMethods();
			for (Method method : methods) { 
				if ("setUpdateDate".equals(method.getName())) {
					method.invoke(o, new Date());
				}
				if ("setDoneDate".equals(method.getName())) {
					method.invoke(o, new Date());
				} 
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return o;
	}

	
	public List<?> findEntityBySql(String sql, Map<String, Object> params,Class<?> entityClass,int page, int rows) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		if ((params != null) && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		q.addEntity(entityClass);
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}
	
	public List<?> findVoBySql(String sql, Map<String, Object> params,Class<?> entityClass,int page, int rows) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		if ((params != null) && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		q.setResultTransformer(Transformers.aliasToBean(entityClass)); 
 
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}
}
