package com.boll6.steel.service;

import com.boll6.steel.entity.TbInfomation;
import com.boll6.steel.entity.TbWechatuser;

import java.math.BigInteger;
import java.util.List;

public interface IInfomationService {
    public TbInfomation saveInfomation(TbInfomation infomation) throws Exception;

    public TbInfomation getInfomationById(Long infoId) throws Exception;

    public List<TbInfomation> getInfomation(Long userId, Integer infoStatus, String infoContent, String fromApp, String orderBy,int page, int rows);
    public BigInteger countInfomation(Long userId, Integer infoStatus, String infoContent, String fromApp);
}
