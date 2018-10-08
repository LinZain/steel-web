package com.boll6.steel.service.impl;

import com.boll6.steel.dao.IBaseDao;
import com.boll6.steel.entity.TbInfomation;
import com.boll6.steel.entity.TbWechatuser;
import com.boll6.steel.service.IInfomationService;
import com.boll6.steel.service.IUserService;
import com.boll6.steel.util.NumberUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

@Service("infomationService")
public class InfomationServiceImpl implements IInfomationService {
    @Autowired
    private IBaseDao<TbInfomation> infomationDao;


    @Override
    public TbInfomation saveInfomation(TbInfomation infomation) throws Exception {
        if (NumberUtils.isNotNullOrZero(infomation.getInfoId())) {
            TbInfomation infomationFDB = infomationDao.get(TbInfomation.class, infomation.getInfoId());
            if (infomationFDB != null) {
                infomationFDB.setViewCount(infomation.getViewCount());
                infomationDao.save(infomationFDB);
            }
        } else {
            infomationDao.save(infomation);
        }
        return infomation;
    }

    @Override
    public List<TbInfomation> getInfomation(Long userId, Integer infoStatus, String infoContent, String fromApp, String orderBy, int page, int rows) {
        String hql = "select * from steelweb.tb_infomation where for_app like :fromApp ";
        HashMap params = new HashMap();
        params.put("fromApp", "%" + fromApp + "%");

        if (NumberUtils.isNotNullOrZero(userId)) {
            hql += " and user_id = :userId ";
            params.put("userId", userId);
        }
        if (NumberUtils.isNotNullOrZero(infoStatus)) {
            hql += " and info_status = :infoStatus ";
            params.put("infoStatus", infoStatus);
        }
        if (StringUtils.isNotBlank(infoContent)) {
            hql += " and info_content like :infoContent ";
            params.put("infoContent", "%" + infoContent + "%");
        }
        if (StringUtils.isNotBlank(orderBy)) {
            hql += " order by " + orderBy + " desc ";
        }

        return (List<TbInfomation>) infomationDao.findEntityBySql(hql, params, TbInfomation.class, page, rows);
    }

    @Override
    public BigInteger countInfomation(Long userId, Integer infoStatus, String infoContent, String fromApp) {
        String hql = "select count(*) from steelweb.tb_infomation where for_app like :fromApp ";
        HashMap params = new HashMap();
        params.put("fromApp", "%" + fromApp + "%");

        if (NumberUtils.isNotNullOrZero(userId)) {
            hql += " and user_id = :userId ";
            params.put("userId", userId);
        }
        if (NumberUtils.isNotNullOrZero(infoStatus)) {
            hql += " and info_status = :infoStatus ";
            params.put("infoStatus", infoStatus);
        }
        if (StringUtils.isNotBlank(infoContent)) {
            hql += " and info_content like :infoContent ";
            params.put("infoContent", "%" + infoContent + "%");
        }

        return infomationDao.countBySql(hql, params);
    }

    public TbInfomation getInfomationById(Long infoId) throws Exception {
        return infomationDao.get(TbInfomation.class, infoId);
    }

}
