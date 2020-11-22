package com.truekai.tank;

import com.truekai.test.ImageTest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * @Author: xk
 * @Date: 2020/11/22 12:13
 * @Desc:
 */
public class RessourceMange {

    public static BufferedImage tankL, tankR, tankU, tankD = null;

    static {
        try {
            tankL = ImageIO.read(ImageTest.class.getClassLoader().
                    getResourceAsStream("images/tankL.gif"));
            tankR = ImageIO.read(ImageTest.class.getClassLoader().
                    getResourceAsStream("images/tankR.gif"));
            tankU = ImageIO.read(ImageTest.class.getClassLoader().
                    getResourceAsStream("images/tankU.gif"));
            tankD = ImageIO.read(ImageTest.class.getClassLoader().
                    getResourceAsStream("images/tankD.gif"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
