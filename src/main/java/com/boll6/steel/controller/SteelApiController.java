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
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
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
    public String getInfomation(Long userId, Integer infoStatus, String infoContent, String fromApp, String orderBy, int page, int rows) {
        JSONObject jsonObject = new JSONObject();
        try {
            List<TbInfomation> infomationList = infomationService.getInfomation(userId, infoStatus, infoContent, fromApp, orderBy, page, rows);
            if (infomationList == null || infomationList.isEmpty()) {
                return null;
            }
            Long count = infomationService.countInfomation(userId, infoStatus, infoContent, fromApp).longValue();
            jsonObject.put("rows", infomationList);
            jsonObject.put("count", count);
            return jsonObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @ResponseBody
    @RequestMapping(value = {"/uploadPic"})
    public String uploadPic(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();
        String path = request.getRealPath("/upload") + "/";
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }
        //获得磁盘文件条目工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();

        //如果没以下两行设置的话,上传大的文件会占用很多内存，
        //设置暂时存放的存储室,这个存储室可以和最终存储文件的目录不同
        /**
         * 原理: 它是先存到暂时存储室，然后再真正写到对应目录的硬盘上，
         * 按理来说当上传一个文件时，其实是上传了两份，第一个是以 .tem 格式的
         * 然后再将其真正写到对应目录的硬盘上
         */
        factory.setRepository(dir);
        //设置缓存的大小，当上传文件的容量超过该缓存时，直接放到暂时存储室
        factory.setSizeThreshold(1024 * 1024);
        //高水平的API文件上传处理
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> list = upload.parseRequest(request);
            FileItem picture = null;
            for (FileItem item : list) {
                //获取表单的属性名字
                String name = item.getFieldName();
                //如果获取的表单信息是普通的 文本 信息
                if (item.isFormField()) {
                    //获取用户具体输入的字符串
                    String value = item.getString();
                    request.setAttribute(name, value);
                } else {
                    picture = item;
                }
            }

            //自定义上传图片的名字为userId.jpg
            String fileName = request.getAttribute("userId") + ".jpg";
            String destPath = path + fileName;

            //真正写到磁盘上
            File file = new File(destPath);
            OutputStream out = new FileOutputStream(file);
            InputStream in = picture.getInputStream();
            int length = 0;
            byte[] buf = new byte[1024];
            // in.read(buf) 每次读到的数据存放在buf 数组中
            while ((length = in.read(buf)) != -1) {
                //在buf数组中取出数据写到（输出流）磁盘上
                out.write(buf, 0, length);
            }
            in.close();
            out.close();
            jsonObject.put("url", destPath);
            jsonObject.put("success", true);
            return jsonObject.toJSONString();
        } catch (FileUploadException e1) {
            e1.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
