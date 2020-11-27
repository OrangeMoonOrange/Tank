package com.truekai.tank.chain;

import com.truekai.tank.GameObject;

/**
 * @Author: xk
 * @Date: 2020/11/27 23:29
 * @Desc: 碰撞器
 */
public interface Collider {
    void collider(GameObject gameObject1, GameObject gameObject2);
}
