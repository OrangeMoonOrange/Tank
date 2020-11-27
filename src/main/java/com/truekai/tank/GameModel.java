package com.truekai.tank;


import com.truekai.tank.chain.ColliderChain;
import com.truekai.tank.constant.Constants;
import com.truekai.tank.prop.PropertyMgr;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xk
 * @Date: 2020/11/26 15:12
 * @Desc: 这就是门面模式。以前TankFream里面要加很多 东西（坦克，子弹...）。现在使用Facade 将这两者分离。
 * GameModel抽离出来 ，同时作为Facade 模式。负责与TankFream打交道
 * <p>
 * GameModel 设计为单例模式
 */
public class GameModel {

    private static final GameModel INSTANCE = new GameModel();

    private Tank myTank;

    static {
        INSTANCE.init();//初始化
    }

    ColliderChain colliderChain = new ColliderChain();//责任链处理 游戏物体之间的碰撞

    private List<GameObject> gameObjects = new ArrayList<>();//爆炸


    private GameModel() {
    }

    //初始化
    private void init() {
        //初始化游戏玩家自己的坦克
        myTank = new Tank(400, 300, Dir.UP, Group.GOOD);
        myTank.setSPEED(20);//设置 游戏玩家坦克的速度
        myTank.setMoving(false);//游戏开始的开始设置 玩家坦克是固定不动得

        //初始化敌人坦克
        int initTankCount = Integer.valueOf((String) PropertyMgr.get(Constants.initTankCount));
        for (int i = 0; i < initTankCount; i++)
            add(new Tank(100 + i * 80, 100, Dir.DOWN, Group.BAD));

        //初始化添加墙
        new Wall(150, 150, 200, 50);
        new Wall(550, 300, 50, 200);
        new Wall(350, 300, 50, 200);

    }

    public void add(GameObject gameObject) {
        this.gameObjects.add(gameObject);
    }

    public void remove(GameObject gameObject) {
        this.gameObjects.remove(gameObject);
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.white);
//        g.drawString("子弹的数量：" + MybulletList.size(), 10, 60);
//        g.drawString("敌人的数量：" + tanks.size(), 10, 80);
//        g.drawString("爆炸的数量：" + explodes.size(), 10, 100);
        g.setColor(c);
        myTank.paint(g);
        for (int i = 0; i < gameObjects.size(); i++) {
            gameObjects.get(i).paint(g);
        }

        //处理 碰撞的逻辑
        //抽象出一个碰撞器
        for (int i = 0; i < gameObjects.size(); i++) {
            for (int j = i + 1; j < gameObjects.size(); j++) {
                GameObject o1 = gameObjects.get(i);
                GameObject o2 = gameObjects.get(j);
                colliderChain.collider(o1, o2);
            }
        }
    }

    //返回 游戏玩家自己的坦克
    public Tank getMainTank() {
        return myTank;
    }

    public static GameModel getInstance() {
        return INSTANCE;
    }
}
