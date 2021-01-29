package com.truekai.tank;

import com.truekai.TankNet.Client;
import com.truekai.tank.constant.Constants;
import com.truekai.tank.prop.PropertyMgr;

/**
 * @Author: xk
 * @Date: 2020/10/15 19:56
 * @Desc:
 */
public class main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame.INSTANCE.setVisible(true);

//        int initTankCount = Integer.valueOf((String) PropertyMgr.get(Constants.initTankCount));
//        //初始化地方坦克
//        for (int i = 0; i < initTankCount; i++) {
//            tr.tanks.add(new Tank(200 + i * 80, 100, Dir.DOWN, Group.BAD, tr));
//        }

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                TankFrame.INSTANCE.repaint();
            }
        }).start();
        Client.INSTANCE.connect();//连接到服务器

    }
}
