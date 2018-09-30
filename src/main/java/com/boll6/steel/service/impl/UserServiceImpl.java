package com.boll6.steel.service.impl;

import com.boll6.steel.dao.IBaseDao;
import com.boll6.steel.entity.TbMarketprice;
import com.boll6.steel.entity.TbWechatproduct;
import com.boll6.steel.entity.TbWechatuser;
import com.boll6.steel.service.IMarketService;
import com.boll6.steel.service.IUserService;
import com.boll6.steel.util.NumberUtils;
import com.boll6.steel.vo.ICSVO;
import com.boll6.steel.vo.SteelNumberVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IBaseDao<TbWechatuser> wechatuserDao;

    @Override
    public List<TbWechatuser> getUserInfo(String openId, String fromApp) {
        String hql = "from TbWechatuser where openId = :openId and source like :fromApp";
        HashMap params = new HashMap();
        params.put("openId", openId);
        params.put("fromApp", "%" + fromApp + "%");
        return wechatuserDao.find(hql, params);
    }

    @Override
    public TbWechatuser saveUser(TbWechatuser wechatuser) throws Exception {
        if (NumberUtils.isNotNullOrZero(wechatuser.getUserId())) {
            TbWechatuser userFDB = wechatuserDao.get(TbWechatuser.class, wechatuser.getUserId());
            if (userFDB != null) {
                userFDB.setAddress(wechatuser.getAddress());
                userFDB.setNickName(wechatuser.getNickName());
                userFDB.setMobile(wechatuser.getMobile());
                userFDB.setEmail(wechatuser.getEmail());
                userFDB.setGender(wechatuser.getGender());
                userFDB.setSlogan(wechatuser.getSlogan());
                userFDB.setAvatarurl(wechatuser.getAvatarurl());
                userFDB.setCompany(wechatuser.getCompany());
                userFDB.setPosition(wechatuser.getPosition());
                userFDB.setPassword(wechatuser.getPassword());
                userFDB.setLoginTime(new Date());
                userFDB.setGenTime(new Date());
                wechatuserDao.save(userFDB);
            } else {
                throw new Exception("用户不存在");
            }

        } else {
            wechatuser.setLoginTime(new Date());
            wechatuser.setGenTime(new Date());
            wechatuserDao.save(wechatuser);
        }
        return wechatuser;
    }

    @Override
    public Long countUserInfo(String openId, String fromApp) {
        String hql = "select (*) from TbWechatuser where openId = :openId and source like :fromApp";
        HashMap params = new HashMap();
        params.put("openId", openId);
        params.put("fromApp", "%" + fromApp + "%");
        return wechatuserDao.count(hql, params);
    }

    @Override
    public Long getUserCount(long userId) {
        TbWechatuser userFDB = wechatuserDao.get(TbWechatuser.class, userId);
        if(userFDB != null){
            return userFDB.getCount();
        }
        return null;
    }


}
