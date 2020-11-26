package com.truekai.tank;

import com.truekai.tank.constant.Constants;
import com.truekai.tank.prop.PropertyMgr;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xk
 * @Date: 2020/11/26 15:12
 * @Desc:
 */
public class GameModel {
    //游戏玩家自己的坦克
    Tank myTank = new Tank(400, 300, Dir.UP, Group.GOOD, this);
    //敌人坦克
    java.util.List<Tank> tanks = new ArrayList<>();
    java.util.List<Bullet> MybulletList = new ArrayList<>();
    List<Explode> explodes = new ArrayList<>();//爆炸

    public GameModel() {
        myTank.setSPEED(10);//设置游戏玩家坦克的速度
        myTank.setMoving(false);//游戏开始的开始设置玩家坦克是固定不动得
        int initTankCount = Integer.valueOf((String) PropertyMgr.get(Constants.initTankCount));
        //初始化地方坦克
        for (int i = 0; i < initTankCount; i++) {
           tanks.add(new Tank(200 + i * 80, 100, Dir.DOWN, Group.BAD, this));
        }
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.white);
        g.drawString("子弹的数量：" + MybulletList.size(), 10, 60);
        g.drawString("敌人的数量：" + tanks.size(), 10, 80);
        g.drawString("爆炸的数量：" + explodes.size(), 10, 100);
        g.setColor(c);
        myTank.paint(g);

        //画出地方坦克
        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }

        //画出子弹
        for (int i = 0; i < MybulletList.size(); i++) {
            MybulletList.get(i).paint(g);
        }
        //画出爆炸
        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(g);
        }

        //监测子弹和坦克是否碰撞
        for (int i = 0; i < MybulletList.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {
                MybulletList.get(i).collidewith(tanks.get(j));
            }
        }

    }

    //返回 游戏玩家自己的坦克
    public Tank getMainTank() {
        return myTank;
    }
}
