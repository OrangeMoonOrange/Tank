package com.truekai.test;

import com.sun.prism.Image;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @Author: xk
 * @Date: 2020/11/22 11:37
 * @Desc:
 */
public class ImageTest {

    @Test
    public void test1() throws Exception {
        BufferedImage image = ImageIO.read(ImageTest.class.getClassLoader().
                getResourceAsStream("images/bulletD.gif"));

    }
}
