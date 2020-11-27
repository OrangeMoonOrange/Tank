package com.truekai.tank.chain;

import com.truekai.tank.*;

/**
 * @Author: xk
 * @Date: 2020/11/27 23:31
 * @Desc: 坦克和子弹相撞的碰撞器
 */
public class BulletTankCollider implements Collider {
    @Override
    public boolean collider(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {
            Bullet bu = (Bullet) o1;
            Tank tank = (Tank) o2;
            if (bu.getGroup() == tank.getGroup())
                return false;
            //需要修改 会一直占用内存 已经修改
            if (bu.getRectangle().intersects(tank.getRectangle())) {
                bu.die();
                tank.die();
                int ex = tank.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
                int ey = tank.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
                GameModel.getInstance().add(new Explode(ex, ey));
            }
        } else if (o1 instanceof Tank && o2 instanceof Bullet) {
            Bullet bu = (Bullet) o2;
            Tank tank = (Tank) o1;

            if (bu.getGroup() == tank.getGroup())
                return false;
            if (bu.getRectangle().intersects(tank.getRectangle())) {
                bu.die();
                tank.die();
                int ex = tank.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
                int ey = tank.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
                GameModel.getInstance().add(new Explode(ex, ey));
            }
        }
        return true;
    }
}
