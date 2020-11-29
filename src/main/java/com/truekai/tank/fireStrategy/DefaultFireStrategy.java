package com.truekai.tank.fireStrategy;

import com.truekai.tank.Bullet;
import com.truekai.tank.GameModel;
import com.truekai.tank.Tank;
import com.truekai.tank.decorator.LineDecorator;
import com.truekai.tank.decorator.RectDecorator;

/**
 * @Author: xk
 * @Date: 2020/11/24 21:40
 * @Desc: 默认策略：发射一发子弹
 */
public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bX = t.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = t.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
       GameModel.getInstance().add( new Bullet(bX, bY, t.dir, t.group));

        //子弹的装饰器
//        GameModel.getInstance().add(
//                new RectDecorator(
//                        new LineDecorator(
//                                new Bullet(bX, bY, t.dir, t.group))));
    }
}
