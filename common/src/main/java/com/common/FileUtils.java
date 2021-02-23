package com.common;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * @Author zhangpenghui
 * @Date 2021/2/23 17:51
 * @Version 1.0
 */
public class FileUtils {
    /**
     * 获取图片信息
     * @param path
     */
    public static void readPic(String path) {
        System.out.println("开始读取图片信息...");
        File jpegFile = new File(path);
        Metadata metadata;
        try {
            metadata = JpegMetadataReader.readMetadata(jpegFile);
            Iterator<Directory> it = metadata.getDirectories().iterator();
            while (it.hasNext()) {
                Directory exif = it.next();
                Iterator<Tag> tags = exif.getTags().iterator();
                while (tags.hasNext()) {
                    Tag tag = tags.next();
                    System.out.println(tag);
                }
            }
            System.out.println("图片信息读取完成！");
        } catch (JpegProcessingException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 经纬度格式化
     * @param lng
     * @return
     */
    public static Double tranformPos(String lng){
        String[] lntArr = lng
                .trim()
                .replace("°", ";")
                .replace("′", ";")
                .replace("'", ";")
                .replace("\"", "")
                .split(";");
        Double result = 0D;
        for (int i = lntArr.length; i >0 ; i--) {
            double v = Double.parseDouble(lntArr[i-1]);
            if(i==1){
                result=v+result;
            }else{
                result=(result+v)/60;
            }
        }
        return result;
    }
}
