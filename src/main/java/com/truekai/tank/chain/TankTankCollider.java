package com.truekai.tank.chain;

import com.truekai.tank.Bullet;
import com.truekai.tank.GameModel;
import com.truekai.tank.GameObject;
import com.truekai.tank.Tank;

/**
 * @Author: xk
 * @Date: 2020/11/27 23:31
 * @Desc: 坦克和子弹相撞的碰撞器
 */
public class TankTankCollider implements Collider {
    @Override
    public boolean collider(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank tank1 = (Tank) o2;
            Tank tank = (Tank) o1;
            if (tank.getRectangle().intersects(tank1.getRectangle())) {
                //如果坦克和坦克相撞了 就回到上一步的位置
                tank.back();
                tank1.back();
            }
        }
        return true;
    }
}
