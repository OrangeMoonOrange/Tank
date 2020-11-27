package com.truekai.tank.chain;

import com.truekai.tank.Bullet;
import com.truekai.tank.GameObject;
import com.truekai.tank.Tank;

/**
 * @Author: xk
 * @Date: 2020/11/27 23:31
 * @Desc: 坦克和子弹相撞的碰撞器
 */
public class BulletTankCollider implements Collider {
    @Override
    public void collider(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {
            Bullet bu = (Bullet) o1;
            Tank tank = (Tank) o2;
            bu.collidewith(tank);
        } else if (o1 instanceof Tank && o2 instanceof Bullet) {
            Bullet bu = (Bullet) o2;
            Tank tank = (Tank) o1;
            bu.collidewith(tank);
        }
    }
}
