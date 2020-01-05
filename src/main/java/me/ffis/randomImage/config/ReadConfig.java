package me.ffis.randomImage.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于读取图片列表和域名白名单数据
 * Created by fanfan on 2020/01/05.
 */

@Slf4j
@Component
public class ReadConfig {
    //创建静态成员变量用于保存图片列表
    public static List<String> images = new ArrayList<>();
    //创建静态成员变量用于域名列表
    public static List<String> domain = new ArrayList<>();

    static {
        //程序启动的时候先加载图片和域名列表到集合中
        loadImages();
        loadDomain();
    }

    //加载图片列表到images中
    public static Boolean loadImages() {
        images.clear();
        BufferedReader bw = null;
        try {
            bw = new BufferedReader(new FileReader("list/images.txt"));
            String line;
            while ((line = bw.readLine())!= null) {
                images.add(line);
            }
        } catch (IOException e) {
            log.error("图片列表加载失败！文件不存在！", e);
            return false;
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        log.info("图片加载成功！");
        return true;
    }

    //加载域名列表到domain集合中
    public static Boolean loadDomain() {
        domain.clear();
        BufferedReader bw = null;
        try {
            bw = new BufferedReader(new FileReader("list/domain.txt"));
            String line;
            while ((line = bw.readLine())!= null) {
                domain.add(line);
            }
        } catch (IOException e) {
            log.error("域名列表加载失败！文件不存在！", e);
            return false;
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        log.info("域名加载成功！");
        return true;
    }
}
