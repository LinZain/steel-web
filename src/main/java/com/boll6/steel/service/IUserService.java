package com.boll6.steel.service;

import com.boll6.steel.entity.TbMarketprice;
import com.boll6.steel.entity.TbWechatproduct;
import com.boll6.steel.entity.TbWechatuser;
import com.boll6.steel.vo.ICSVO;
import com.boll6.steel.vo.SteelNumberVO;

import java.math.BigInteger;
import java.util.List;

public interface IUserService {
	public List<TbWechatuser> getUserInfo(String openId, String fromApp);
	public TbWechatuser saveUser(TbWechatuser wechatuser)throws Exception;
	public Long countUserInfo(String openId, String fromApp);
	public Long getUserCount(long userId);
}
