package org.zyz.core.utils;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * 文件工具类
 */
public class FileUtils {

    /**
     * 获取模块Resource下的文件路径
     * @param filePath
     * @return
     */
    public static String getClassFilePath(String filePath){
        try {
            return new ClassPathResource(filePath).getFile().getAbsolutePath();
        }catch (IOException e){
            return "";
        }
    }
}
