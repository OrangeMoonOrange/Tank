package com.truekai.tank.observer;

import com.truekai.tank.Tank;

/**
 * @Author: xk
 * @Date: 2020/11/29 12:34
 * @Desc:
 */
public class TankFireEvent extends Event<Tank> {
    public Tank tank;

    public TankFireEvent(Tank tank) {
        this.tank = tank;
    }

    @Override
    Tank getSource() {
        return tank;
    }
}
