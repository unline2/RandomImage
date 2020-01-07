package me.ffis.randomImage.service;

import lombok.extern.slf4j.Slf4j;
import me.ffis.randomImage.config.ReadListConfig;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fanfan on 2020/01/06.
 */

@Slf4j
@Service
public class ImageService {

    //随机获取images集合中的图片地址
    public String getRandomImages(String imageFile) {
        //屏蔽domains的请求
        if ("domains".equals(imageFile)) {
            return "404";
        }
        //判断集合是否为空
        if (ReadListConfig.listMap.size() == 0) {
            log.error("listMap集合为空，读取列表文件失败");
            return null;
        } else {
            //根据传入的参数images获取对应的集合
            List<String> images = ReadListConfig.listMap.get(imageFile + ".txt");
            if (images == null) {
                return "404";
            }
            //根据images集合大小生成随机数
            int index = (int) (Math.random() * images.size());
            //获取随机的图片地址
            return images.get(index);
        }
    }
}
