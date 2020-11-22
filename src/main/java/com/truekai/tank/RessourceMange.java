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
    public static BufferedImage bulletL, bulletR, bulletU, bulletD = null;
    public static BufferedImage[] explodes = new BufferedImage[16];
    static {
        try {
            tankL = ImageIO.read(RessourceMange.class.getClassLoader().
                    getResourceAsStream("images/tankL.gif"));
            tankR = ImageIO.read(RessourceMange.class.getClassLoader().
                    getResourceAsStream("images/tankR.gif"));
            tankU = ImageIO.read(RessourceMange.class.getClassLoader().
                    getResourceAsStream("images/tankU.gif"));
            tankD = ImageIO.read(RessourceMange.class.getClassLoader().
                    getResourceAsStream("images/tankD.gif"));

            bulletL = ImageIO.read(RessourceMange.class.getClassLoader().
                    getResourceAsStream("images/bulletL.gif"));
            bulletR = ImageIO.read(RessourceMange.class.getClassLoader().
                    getResourceAsStream("images/bulletR.gif"));
            bulletU = ImageIO.read(RessourceMange.class.getClassLoader().
                    getResourceAsStream("images/bulletU.gif"));
            bulletD = ImageIO.read(RessourceMange.class.getClassLoader().
                    getResourceAsStream("images/bulletD.gif"));
            for(int i=0; i<16; i++)//加载爆炸的图片
                explodes[i] = ImageIO.read(RessourceMange.class.getClassLoader().getResourceAsStream("images/e" + (i+1) + ".gif"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
