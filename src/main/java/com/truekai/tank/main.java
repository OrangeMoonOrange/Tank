package com.truekai.tank;

import com.truekai.tank.constant.Constants;
import com.truekai.tank.prop.PropertyMgr;

/**
 * @Author: xk
 * @Date: 2020/10/15 19:56
 * @Desc:
 */
public class main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tr = new TankFrame();
        //music
        //new Thread(()->new Audio("audio/war1.wav").loop()).start();


        while (true) {
            Thread.sleep(50);
            tr.repaint();
        }
    }
}
