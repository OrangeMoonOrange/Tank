package com.truekai.tank.chain;

import com.truekai.tank.Bullet;
import com.truekai.tank.GameModel;
import com.truekai.tank.GameObject;
import com.truekai.tank.Wall;

/**
 * @Author: xk
 * @Date: 2020/11/28 4:51
 * @Desc: 子弹和墙相撞的逻辑
 */
public class BulletWallCollider implements Collider {
    @Override
    public boolean collider(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Wall) {
            Bullet bullet = (Bullet) o1;
            Wall wall = (Wall) o2;
            if (bullet.getRectangle().intersects(wall.rectangle)) {
                bullet.die();//相撞的话 子弹死掉就可以了。但是责任链要继续下去
            }
        } else if (o2 instanceof Bullet && o1 instanceof Wall) {
            Bullet bullet = (Bullet) o2;
            Wall wall = (Wall) o1;
            if (bullet.getRectangle().intersects(wall.rectangle)) {
                bullet.die();//相撞的话 子弹死掉就可以了。但是责任链要继续下去
            }
        }
        return true;
    }
}
