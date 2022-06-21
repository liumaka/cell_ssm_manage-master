package com.qfedu.demo.controller;


import com.qfedu.demo.garbage.UploadUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("upload")
public class UploadController {

    @RequestMapping("image")
    @ResponseBody
    public Map<String,Object> image(MultipartFile file){
        Map<String, Object> result = new HashMap<>();
        //调用工具类完成文件上传
        String imagePath = UploadUtils.upload(file);
        System.out.println(imagePath);
        if (imagePath != null){
            //创建一个HashMap用来存放图片路径
            HashMap hashMap = new HashMap();
            hashMap.put("src",imagePath);
            result.put("code",1);
            result.put("msg","上传成功");
            result.put("data",hashMap);
            result.put("src",imagePath);
        }else{
            result.put("code",0);
            result.put("msg","上传失败");
        }
        return result;
    }


    @RequestMapping("addImage")
    @ResponseBody
    public String addImage(String imageDescribe,String imagePath){
        //获得图片地址和图片描述
        /*
            这里我们只做打印的操作，实际上，我们应该在这里调用
            方法，把图片地址和图片的描述加入到数据库中，但是这些
            相信大家已经回了，所以，就不再写了。
         */

        System.out.println("图片描述："+imageDescribe);
        System.out.println("图片地址："+imagePath);

        return "1";
    }

    @RequestMapping("deleteImage")
    @ResponseBody
    public String deleteImage(){
        UploadUtils.delete("84e15dddb4284fc8a4877c93bcc9d81f-dl.jpg");
        return "1";
    }
}
