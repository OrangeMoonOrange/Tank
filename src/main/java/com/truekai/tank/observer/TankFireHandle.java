package com.truekai.tank.observer;

import com.truekai.tank.Tank;

/**
 * @Author: xk
 * @Date: 2020/11/29 12:41
 * @Desc:
 */
public class TankFireHandle implements TankFireObserver {
    @Override
    public void tankFireAction(TankFireEvent event) {
        Tank tank = event.getSource();
        tank.fire();
    }
}
