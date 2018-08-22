package com.cwb.controller;

import com.cwb.bean.UpLoadFileResult;
import com.cwb.util.ResponseUtils;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/upload")
public class UploadController {
    //上传图片  通过@RequestParam(required = false) MultipartFile获取图片
    @RequestMapping(value = "/uploadPic.do")
    @ResponseBody
    public UpLoadFileResult uploadBrandPic(@RequestParam(required = false) MultipartFile pic, HttpServletResponse response) {
        //图片名称生成策略---采用时间格式(精确到毫秒)并追加随机3位(10以内)数字
        //精确到毫秒
        System.out.println("begin");
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String picName = df.format(new Date());
        //随机再生成3位 10以内的数
        Random r = new Random();
        for (int i = 0; i < 3; i++) {
            picName += r.nextInt(10);
        }
        //获取扩展名
        String originalFilename = pic.getOriginalFilename();
        String ext = FilenameUtils.getExtension(originalFilename);
        //相对路径
        String path = "upload/" + picName + "." + ext;
        System.out.println(path);
        //全路径，该路径为后面创建的tomcat图片服务器的上传图片的web工程下存放图片的路径
        String url = "http://172.16.17.6:8080/ImageWeb/" + path;
        //jersey 发送另一台Tomcat(可读写的)
        Client client = new Client();
        WebResource resource = client.resource(url);

        UpLoadFileResult result = new UpLoadFileResult();

        try {
            resource.put(String.class, pic.getBytes());
            result.setError(0);
            result.setUrl(url);
            result.setMessage("upload success");

        } catch (UniformInterfaceException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (ClientHandlerException e1) {
            // TODO Auto-generated catch block
            result.setError(1);
            result.setMessage("upload fail");
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
//        JSONObject json = new JSONObject();
//        json.put("url", url);
//        json.put("path", path);
//        ResponseUtils.renderJson(response, json.toString());
//        Map<String,String> map = new HashMap<>();
//        map.put("url",url);
//        map.put("path",path);
//        ResponseUtils.renderJson(response, map.toString());
        return result;
    }
}
