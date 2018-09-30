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
    public List<TbInfomation> getInfomation(Long userId, Integer infoStatus, String infoContent, String fromApp, String orderBy) {
        String hql = "from TbInfomation where forApp like :fromApp ";
        HashMap params = new HashMap();
        params.put("fromApp", "%" + fromApp + "%");

        if (NumberUtils.isNotNullOrZero(userId)) {
            hql += "and userId = :userId";
            params.put("userId", userId);
        }
        if (NumberUtils.isNotNullOrZero(infoStatus)) {
            hql += "and infoStatus = :infoStatus";
            params.put("infoStatus", infoStatus);
        }
        if (StringUtils.isNotBlank(infoContent)) {
            hql += "and infoContent like :infoContent";
            params.put("infoContent", "%" + infoContent + "%");
        }
        if (StringUtils.isNotBlank(orderBy)) {
            hql += " order by :orderBy desc";
            params.put("orderBy", orderBy);
        }

        return infomationDao.find(hql, params);
    }

    public TbInfomation getInfomationById(Long infoId) throws Exception {
        return infomationDao.get(TbInfomation.class, infoId);
    }

}
