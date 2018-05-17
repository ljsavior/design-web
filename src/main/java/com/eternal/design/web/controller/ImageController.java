package com.eternal.design.web.controller;

import com.eternal.design.util.DateFormatUtil;
import com.eternal.design.web.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;

@Controller
public class ImageController {
    private Logger logger = LoggerFactory.getLogger(ImageController.class);

    @Value("${myConfig.img-file-dir}")
    private String imgFileDir;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @RequestMapping("/getImage/{imgName:.+}")
    public void getImage(@PathVariable String imgName, HttpServletResponse response) {
        if(imgName.toLowerCase().endsWith(".jpg") || imgName.toLowerCase().endsWith(".jpeg")) {
            response.setContentType("image/jpeg");
        } else if(imgName.toLowerCase().endsWith(".png")) {
            response.setContentType("image/png");
        } else if(imgName.toLowerCase().endsWith(".bmp")) {
            response.setContentType("image/bitmap");
        } else {
            throw new IllegalArgumentException("imgName错误.imgName=" + imgName);
        }

        String imgPath = imgFileDir.concat("/").concat(imgName);

        try {
            Files.copy(Paths.get(imgPath), response.getOutputStream());
        } catch (IOException e) {
            logger.error("获取图片异常", e);
            e.printStackTrace();
        }
    }

    @RequestMapping("/uploadImage.json")
    @ResponseBody
    public Result uploadImage(MultipartFile img) {
        try {
            String orignName = img.getOriginalFilename();
            String suffix = orignName.substring(orignName.lastIndexOf('.'));
            String imgName = generateImageName(suffix);
            String imgPath = imgFileDir.concat("/").concat(imgName);
            Files.copy(img.getInputStream(), Paths.get(imgPath));
            return new Result(true, "", imgName);
        } catch (IOException e) {
            logger.error("图片上传异常.", e);
            e.printStackTrace();
            return new Result(false, e.getMessage(), null);
        }
    }

    private String generateImageName(String suffix) {
        String date = DateFormatUtil.format(new Date(), "yyyyMMdd");
        String redisKey = "imgId" + date;

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        RedisAtomicLong counter = new RedisAtomicLong(redisKey, redisTemplate.getConnectionFactory());
        long count = counter.incrementAndGet();
        if(count == 1) {
            counter.expireAt(calendar.getTime());
        }

        return String.format("%s_%010d%s", date, count, suffix);
    }
}
