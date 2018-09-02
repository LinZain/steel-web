package com.boll6.steel.service;

import com.boll6.steel.entity.TbMarketprice;
import com.boll6.steel.entity.TbWechatproduct;
import com.boll6.steel.vo.ICSVO;
import com.boll6.steel.vo.SteelNumberVO;

import java.math.BigInteger;
import java.util.List;

public interface IMarketService {

	public List<TbMarketprice> getMarketPrice(String taskDate, String taskType);
	public BigInteger countMarketPrice(String taskDate, String taskType);

	public List<TbWechatproduct> getProductList(String fromApp, String webWord);
	public BigInteger countProductList(String fromApp, String webWord);

	public List<SteelNumberVO> getSteelNumber(String steelNumber, String steelType);
	public BigInteger countSteelNumber(String steelNumber, String steelType);

	public List<SteelNumberVO> getSteelNumberByICS(String icsCode);
	public BigInteger countSteelNumberByICS(String icsCode);

	public List<ICSVO> getICS(String stdType);
	public BigInteger countICS(String stdType);
}
