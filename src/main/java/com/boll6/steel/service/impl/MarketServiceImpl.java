package com.boll6.steel.service.impl;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.boll6.steel.entity.TbMarketprice;
import com.boll6.steel.entity.TbWechatproduct;
import com.boll6.steel.service.IMarketService;
import com.boll6.steel.vo.ICSVO;
import com.boll6.steel.vo.SteelNumberVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boll6.steel.dao.IBaseDao;

@Service("marketService")
public class MarketServiceImpl implements IMarketService {
    @Autowired
    private IBaseDao<TbMarketprice> marketpriceDao;
    @Autowired
    private IBaseDao<TbWechatproduct> wechatproductDao;

    @Override
    public List<TbMarketprice> getMarketPrice(String taskDate, String taskType) {
        String sql = "select * from steelweb.tb_marketPrice WHERE task_date= :taskDate AND task_type= :taskType";
        HashMap params = new HashMap();
        params.put("taskDate", taskDate);
        params.put("taskType", taskType);
        return (List<TbMarketprice>) marketpriceDao.findEntityBySql(sql, params,TbMarketprice.class);
    }

    @Override
    public BigInteger countMarketPrice(String taskDate, String taskType) {
        String sql = "select count(*) from steelweb.tb_marketPrice WHERE task_date= :taskDate AND task_type= :taskType";
        HashMap params = new HashMap();
        params.put("taskDate", taskDate);
        params.put("taskType", taskType);
        return marketpriceDao.countBySql(sql, params);
    }

    @Override
    public List<TbWechatproduct> getProductList(String fromApp, String keyWord) {
        String sql = "SELECT * FROM steelweb.tb_wechatProduct WHERE pdt_type= :fromApp AND id in(select pdt_id from steelweb.tb_searchMap where key_word like :keyWord )order by pdt_weight DESC";
        HashMap params = new HashMap();
        params.put("fromApp", fromApp);
        params.put("keyWord", "%" + keyWord + "%");
        return (List<TbWechatproduct>) wechatproductDao.findEntityBySql(sql, params, TbWechatproduct.class);
    }

    @Override
    public BigInteger countProductList(String fromApp, String keyWord) {
        String sql = "SELECT count(*) FROM steelweb.tb_wechatProduct WHERE pdt_type= :fromApp AND id in(select pdt_id from steelweb.tb_searchMap where key_word like :keyWord )order by pdt_weight DESC";
        HashMap params = new HashMap();
        params.put("fromApp", fromApp);
        params.put("keyWord", "%" + keyWord + "%");
        return wechatproductDao.countBySql(sql, params);
    }

    @Override
    public List<SteelNumberVO> getSteelNumber(String steelNumber, String steelType) {
        String sql = "SELECT c.steel_number as steelNumber,c.std_number as stdNumber,c.steel_type as steelType,c.similar_material as similarMaterial,d.steel_number AS theSameMaterial FROM(SELECT a.steel_number,std_number,steel_type, b.steel_number AS similar_material,a.theSame_material FROM (SELECT steel_number,std_number,group_name AS steel_type, chm_composition,pys_performance,mec_performance,similar_material,theSame_material FROM steelweb.tb_material,steelweb.tb_group  WHERE tb_material.steel_type=tb_group.id ";
        HashMap params = new HashMap();

        if (StringUtils.isNotBlank(steelNumber)) {
            sql += "AND steel_number like :steelNumber ";
            params.put("steelNumber", "%" + steelNumber + "%");
        }
        if (StringUtils.isNotBlank(steelType)) {
            sql += "AND steel_type like :steelType";
            params.put("steelType", "%" + steelType + "%");
        }

        sql += ") AS a LEFT JOIN (SELECT id,steel_number FROM steelweb.tb_material ) AS b  ON a.similar_material = b.id) AS c LEFT JOIN (SELECT id,steel_number FROM steelweb.tb_material ) AS d ON c.theSame_material=d.id";

        return (List<SteelNumberVO>) wechatproductDao.findVoBySql(sql, params, SteelNumberVO.class);
    }

    @Override
    public BigInteger countSteelNumber(String steelNumber, String steelType) {
        String sql = "SELECT count(*) FROM(SELECT a.steel_number,std_number,steel_type, b.steel_number AS similar_material,a.theSame_material FROM (SELECT steel_number,std_number,group_name AS steel_type, chm_composition,pys_performance,mec_performance,similar_material,theSame_material FROM steelweb.tb_material,steelweb.tb_group  WHERE tb_material.steel_type=tb_group.id ";
        HashMap params = new HashMap();

        if (StringUtils.isNotBlank(steelNumber)) {
            sql += "AND steel_number like :steelNumber ";
            params.put("steelNumber", "%" + steelNumber + "%");
        }
        if (StringUtils.isNotBlank(steelType)) {
            sql += "AND steel_type like :steelType";
            params.put("steelType", "%" + steelType + "%");
        }

        sql += ") AS a LEFT JOIN (SELECT id,steel_number FROM steelweb.tb_material ) AS b  ON a.similar_material = b.id) AS c LEFT JOIN (SELECT id,steel_number FROM steelweb.tb_material ) AS d ON c.theSame_material=d.id";

        return wechatproductDao.countBySql(sql, params);
    }


    @Override
    public List<SteelNumberVO> getSteelNumberByICS(String icsCode) {
        String sql = "SELECT c.steel_number as steelNumber,c.std_number as stdNumber,c.steel_type as steelType,c.similar_material as similarMaterial,d.steel_number AS theSameMaterial FROM(SELECT a.steel_number,std_number,steel_type, b.steel_number AS similar_material,a.theSame_material FROM (SELECT steel_number,std_number,group_name AS steel_type, chm_composition,pys_performance,mec_performance, similar_material,theSame_material FROM steelweb.tb_material,steelweb.tb_group  WHERE tb_material.steel_type=tb_group.id AND std_number IN(SELECT std_number FROM steelweb.tb_standardDtl,steelweb.tb_ics WHERE tb_ics.code = tb_standardDtl.std_icsClass AND tb_ics.code like :icsCode)) AS a LEFT JOIN (SELECT id,steel_number FROM steelweb.tb_material ) AS b ON a.similar_material = b.id) AS c LEFT JOIN (SELECT id,steel_number FROM steelweb.tb_material ) AS d ON c.theSame_material=d.id";
        HashMap params = new HashMap();

        params.put("icsCode", icsCode + "%");

        return (List<SteelNumberVO>) wechatproductDao.findVoBySql(sql, params, SteelNumberVO.class);
    }

    @Override
    public BigInteger countSteelNumberByICS(String icsCode) {
        String sql = "SELECT count(*) FROM (SELECT steel_number,std_number,group_name AS steel_type, chm_composition,pys_performance,mec_performance, similar_material,theSame_material FROM steelweb.tb_material,steelweb.tb_group  WHERE tb_material.steel_type=tb_group.id AND std_number IN(SELECT std_number FROM steelweb.tb_standardDtl,steelweb.tb_ics WHERE tb_ics.code = tb_standardDtl.std_icsClass AND tb_ics.code like :icsCode)) AS a LEFT JOIN (SELECT id,steel_number FROM steelweb.tb_material ) AS b ON a.similar_material = b.id) AS c LEFT JOIN (SELECT id,steel_number FROM steelweb.tb_material ) AS d ON c.theSame_material=d.id";
        HashMap params = new HashMap();

        params.put("icsCode", icsCode + "%");

        return wechatproductDao.countBySql(sql, params);
    }

    @Override
    public List<ICSVO> getICS(String stdType) {
        String sql = "SELECT std_icsClass as icsCode,ch_name as icsName FROM (SELECT distinct(std_icsClass),b.ch_name FROM (SELECT * from steelweb.tb_standardDtl WHERE std_type like :stdType)a LEFT JOIN (SELECT code,ch_name from steelweb.tb_ics) b ON a.std_icsClass=b.code) d WHERE d.ch_name is not null";
        HashMap params = new HashMap();

        params.put("stdType",stdType);

        return (List<ICSVO>) wechatproductDao.findVoBySql(sql, params, ICSVO.class);
    }

    @Override
    public BigInteger countICS(String stdType) {
        String sql = "SELECT count(*) FROM (SELECT distinct(std_icsClass),b.ch_name FROM (SELECT * from steelweb.tb_standardDtl WHERE std_type like :stdType)a LEFT JOIN (SELECT code,ch_name from steelweb.tb_ics) b ON a.std_icsClass=b.code) d WHERE d.ch_name is not null";
        HashMap params = new HashMap();

        params.put("stdType",stdType);

        return wechatproductDao.countBySql(sql, params);
    }
}
