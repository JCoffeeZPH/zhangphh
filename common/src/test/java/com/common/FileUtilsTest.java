package com.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author zhangpenghui
 * @Date 2021/2/23 17:52
 * @Version 1.0
 */
class FileUtilsTest {

    @Test
    void readPic() {
//        FileUtils.readPic("D:\\usefulfiles\\test.jpg");
        //116.285611,39.956537
        //Latitude - 39° 56' 55.33" Longitude - 116° 16' 22.9"
        System.out.println(FileUtils.tranformPos("39° 56' 55.33"));
        System.out.println(FileUtils.tranformPos("116°16' 22.9"));
        //http://gc.ditu.aliyun.com/regeocoding?l=116.285611,log+"&type=010
    }
}