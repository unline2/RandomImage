package me.ffis.randomImage.controller;

import lombok.extern.slf4j.Slf4j;
import me.ffis.randomImage.config.ReadConfig;
import me.ffis.randomImage.pojo.reponse.ReponseCode;
import me.ffis.randomImage.pojo.reponse.Result;
import me.ffis.randomImage.pojo.reponse.ResultResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by fanfan on 2020/01/05.
 */

@Slf4j
@Controller
public class ImageController {

    //获取随机图片
    @ResponseBody
    @GetMapping("images")
    public void getRandomImages(HttpServletResponse response) {
        //givenList.get((int) (Math.random() * givenList.size()));
        //根据images集合大小生成随机数
        int index = (int) (Math.random() * ReadConfig.images.size());
        //获取随机的图片地址
        String imgUrl = ReadConfig.images.get(index);
        try {
            //重定向到图片地址
            response.sendRedirect(imgUrl);
        } catch (IOException e) {
            log.error("重定向到图片地址失败！", e);
        }
    }

    /**
     * 刷新图片缓存
     * @return 刷新结果
     */
    @ResponseBody
    @GetMapping("flush")
    public Result flushCache() {
        log.info("刷新图片缓存");
        Boolean imagesflag = ReadConfig.loadImages();
        Boolean domainflag = ReadConfig.loadDomain();

        if (!imagesflag && !domainflag) {
            return new ResultResponse(ReponseCode.FLUSH_FAIL);
        }
        if (!imagesflag) {
            return new ResultResponse(ReponseCode.FLUSH_IMAGES_FAIL);
        }
        if (!domainflag) {
            return new ResultResponse(ReponseCode.FLUSH_DOMAIN_FAIL);
        }

        List<String> domain = ReadConfig.domain;
        List<String> images = ReadConfig.images;
        return new ResultResponse(ReponseCode.FLUSH_SUCCESS);
    }
}
