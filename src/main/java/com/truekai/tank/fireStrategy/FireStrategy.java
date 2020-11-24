package com.truekai.tank.fireStrategy;

import com.truekai.tank.Tank;

/**
 * @Author: xk
 * @Date: 2020/11/24 21:38
 * @Desc: 发射子弹的策略接口
 */
public interface FireStrategy {
    void fire(Tank t);
}
