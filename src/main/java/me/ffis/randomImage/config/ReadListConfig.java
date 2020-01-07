package me.ffis.randomImage.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于读取图片列表和域名白名单数据
 * Created by fanfan on 2020/01/05.
 */

@Slf4j
@Component
public class ReadListConfig {
    //创建全局静态成员变量listMap用于保存列表数据
    public static Map<String, List<String>> listMap = new HashMap<>();

    static {
        //程序启动的时候先加载list文件夹中的文件内容列表到集合中
        loadList();
    }
    //加载list文件夹下的文件列表到list集合中
    public static Boolean loadList() {
        //清空集合
        listMap.clear();
        //创建list文件夹的文件对象
        File file = new File("list");
        if (!file.exists()) {
            log.error("list文件夹不存在！");
            return false;
        }
        //获取list文件夹下的文件列表
        String[] list = file.list();
        assert list != null;
        if (list.length == 0) {
            log.error("list文件夹为空！");
            return false;
        }
        for (String listFile : list) {
            //遍历集合，将.txt结尾的文件内容存到集合中
            if (listFile.endsWith(".txt")) {
                List<String> arrList = loadFileToList(listFile);
                listMap.put(listFile, arrList);
            }
        }
        return true;
    }

    //读取list文件夹下指定文件的内容到map集合中
    private static List<String> loadFileToList(String listFileName) {
        List<String> listFile = new ArrayList<>();
        BufferedReader bw = null;
        try {
            bw = new BufferedReader(new FileReader("list/" + listFileName));
            String line;
            while ((line = bw.readLine())!= null) {
                listFile.add(line);
            }
        } catch (IOException e) {
            log.error("列表文件 " + listFileName + " 加载失败！文件不存在！", e);
            return null;
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        log.info("列表文件 " + listFileName + " 加载成功！");
        return listFile;
    }
}
