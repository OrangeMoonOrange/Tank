package com.truekai.tank.chain;

import com.truekai.tank.*;

/**
 * @Author: xk
 * @Date: 2020/11/28 2:20
 * @Desc: 坦克和墙相撞的 碰撞器
 */
public class TankWallCollider implements Collider {
    @Override
    public boolean collider(GameObject o1, GameObject o2, GameModel gameModel) {
        if (o1 instanceof Tank && o2 instanceof Wall) {
            Tank tank = (Tank) o1;
            Wall wall = (Wall) o2;
            if (tank.getRectangle().intersects(wall.rectangle)) {
                tank.back();//坦克和墙相撞 后回到上一次的位置
            }
        } else if (o2 instanceof Tank && o1 instanceof Wall) {
            Tank tank = (Tank) o2;
            Wall wall = (Wall) o1;
            if (tank.getRectangle().intersects(wall.rectangle)) {
                tank.back();//坦克和墙相撞 后回到上一次的位置
            }
        }
        return true;
    }
}
