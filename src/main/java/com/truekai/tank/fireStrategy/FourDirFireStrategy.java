package com.truekai.tank.fireStrategy;

import com.truekai.tank.Bullet;
import com.truekai.tank.Dir;
import com.truekai.tank.Tank;

/**
 * @Author: xk
 * @Date: 2020/11/24 21:41
 * @Desc: 发射四发子弹的策略
 */
public class FourDirFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bX = t.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = t.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;

        Dir[] dirs = Dir.values();
        for(Dir dir : dirs) {
            new Bullet(bX, bY, dir, t.group, t.tf);
        }
    }
}
