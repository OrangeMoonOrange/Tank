//package com.truekai.tank.fireStrategy;
//
//import com.truekai.tank.Bullet;
//import com.truekai.tank.Tank;
//
///**
// * @Author: xk
// * @Date: 2020/11/24 21:40
// * @Desc: 默认策略：发射一发子弹
// */
//public class DefaultFireStrategy implements FireStrategy {
//    @Override
//    public void fire(Tank t) {
//        int bX = t.getX() + Tank.WIDTH/2 - Bullet.WIDTH/2;
//        int bY = t.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
//        new Bullet(bX, bY, t.dir, t.group, t.tf);
//    }
//}
