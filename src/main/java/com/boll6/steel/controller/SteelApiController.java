package com.boll6.steel.controller;

import com.alibaba.fastjson.JSONObject;
import com.boll6.steel.entity.TbInfomation;
import com.boll6.steel.entity.TbMarketprice;
import com.boll6.steel.entity.TbWechatproduct;
import com.boll6.steel.entity.TbWechatuser;
import com.boll6.steel.service.IInfomationService;
import com.boll6.steel.service.IMarketService;
import com.boll6.steel.service.IUserService;
import com.boll6.steel.util.NumberUtils;
import com.boll6.steel.vo.ICSVO;
import com.boll6.steel.vo.SteelNumberVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

@Controller
@RequestMapping(value = "/steel")
public class SteelApiController {
    @Autowired
    private IMarketService marketService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IInfomationService infomationService;

    @ResponseBody
    @RequestMapping(value = {"/getMarketPrice"}, method = {RequestMethod.GET})
    public String getMarketPrice(String taskDate, String taskType) throws IOException {
        JSONObject jsonObject = new JSONObject();
        try {
            if (!StringUtils.isNotBlank(taskDate) && !StringUtils.isNotBlank(taskType)) {
                return null;
            }

            List<TbMarketprice> list = marketService.getMarketPrice(taskDate, taskType);
            if (list == null || list.isEmpty()) {
                return null;
            }
            long count = marketService.countMarketPrice(taskDate, taskType).longValue();
            jsonObject.put("rows", list);
            jsonObject.put("total", count);
            return jsonObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @ResponseBody
    @RequestMapping(value = {"/getProductList"}, method = {RequestMethod.GET})
    public String getProductList(String fromApp, String keyWord) {
        JSONObject jsonObject = new JSONObject();
        try {
            if (!StringUtils.isNotBlank(fromApp) && !StringUtils.isNotBlank(keyWord)) {
                return null;
            }

            List<TbWechatproduct> list = marketService.getProductList(fromApp, keyWord);
            if (list == null || list.isEmpty()) {
                return null;
            }
            long count = marketService.countProductList(fromApp, keyWord).longValue();
            jsonObject.put("rows", list);
            jsonObject.put("total", count);
            return jsonObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @ResponseBody
    @RequestMapping(value = {"/getSteelNumber"}, method = {RequestMethod.GET})
    public String getSteelNumber(String steelNumber, String steelType) {
        JSONObject jsonObject = new JSONObject();
        try {
            List<SteelNumberVO> list = marketService.getSteelNumber(steelNumber, steelType);
            if (list == null || list.isEmpty()) {
                return null;
            }
            long count = marketService.countSteelNumber(steelNumber, steelType).longValue();
            jsonObject.put("rows", list);
            jsonObject.put("total", count);
            return jsonObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @ResponseBody
    @RequestMapping(value = {"/getSteelNumberByICS"}, method = {RequestMethod.GET})
    public String getSteelNumberByICS(String icsCode) {
        JSONObject jsonObject = new JSONObject();
        try {
            if (!StringUtils.isNotBlank(icsCode)) {
                return null;
            }

            List<SteelNumberVO> list = marketService.getSteelNumberByICS(icsCode);
            if (list == null || list.isEmpty()) {
                return null;
            }
            long count = marketService.countSteelNumberByICS(icsCode).longValue();
            jsonObject.put("rows", list);
            jsonObject.put("total", count);
            return jsonObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @ResponseBody
    @RequestMapping(value = {"/getICS"}, method = {RequestMethod.GET})
    public String getICS(String stdType) {
        JSONObject jsonObject = new JSONObject();
        try {
            if (!StringUtils.isNotBlank(stdType)) {
                return null;
            }

            List<ICSVO> list = marketService.getICS(stdType);
            if (list == null || list.isEmpty()) {
                return null;
            }
            BigInteger count = marketService.countICS(stdType);
            jsonObject.put("rows", list);
            jsonObject.put("total", count.bitCount());
            return jsonObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @ResponseBody
    @RequestMapping(value = {"/getUserInfo"}, method = {RequestMethod.GET})
    public String getUserInfo(String openId, String fromApp) {
        JSONObject jsonObject = new JSONObject();
        try {
            List<TbWechatuser> list = userService.getUserInfo(openId, fromApp);
            if (list == null || list.isEmpty()) {
                return null;
            }
            jsonObject.put("rows", list);
            return jsonObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @ResponseBody
    @RequestMapping(value = {"/registUser"}, method = {RequestMethod.GET})
    public String registUser(TbWechatuser wechatuser) {
        JSONObject jsonObject = new JSONObject();
        try {
            TbWechatuser wechatuserFDB = userService.saveUser(wechatuser);
            jsonObject.put("data", wechatuser);
            return jsonObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @ResponseBody
    @RequestMapping(value = {"/updateUserInfo"}, method = {RequestMethod.GET})
    public String updateUserInfo(TbWechatuser wechatuser) {
        JSONObject jsonObject = new JSONObject();
        try {
            TbWechatuser wechatuserFDB = userService.saveUser(wechatuser);
            jsonObject.put("data", wechatuser);
            return jsonObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @ResponseBody
    @RequestMapping(value = {"/getCount"}, method = {RequestMethod.GET})
    public String getCount(Long userId) {
        JSONObject jsonObject = new JSONObject();
        try {
            Long count = userService.getUserCount(userId);
            if (NumberUtils.isNotNullOrZero(count)) {
                jsonObject.put("count", count);
                return jsonObject.toString();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @ResponseBody
    @RequestMapping(value = {"/submitInfo"}, method = {RequestMethod.GET})
    public String submitInfo(TbInfomation infomation) {
        JSONObject jsonObject = new JSONObject();
        try {

            TbInfomation infomationFDB = infomationService.saveInfomation(infomation);
            jsonObject.put("data", infomationFDB);
            return jsonObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @ResponseBody
    @RequestMapping(value = {"/addViewCount"}, method = {RequestMethod.GET})
    public String addViewCount(Long infoId) {
        JSONObject jsonObject = new JSONObject();
        try {
            if (!NumberUtils.isNotNullOrZero(infoId)) {
                return null;
            }
            TbInfomation infomationFDB = infomationService.getInfomationById(infoId);
            if (infomationFDB != null) {
                infomationFDB.setViewCount(infomationFDB.getViewCount() + 1);
                infomationService.saveInfomation(infomationFDB);
                jsonObject.put("data", infomationFDB);
            }
            return jsonObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @ResponseBody
    @RequestMapping(value = {"/getInfomation"}, method = {RequestMethod.GET})
    public String getInfomation(Long userId, Integer infoStatus, String infoContent, String fromApp, String orderBy) {
        JSONObject jsonObject = new JSONObject();
        try {
            List<TbInfomation> infomationList = infomationService.getInfomation(userId, infoStatus, infoContent, fromApp, orderBy);
            if (infomationList == null || infomationList.isEmpty()) {
                return null;
            }
            jsonObject.put("rows", infomationList);
            return jsonObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
