package com.truekai.tank.chain;

import com.truekai.tank.GameModel;
import com.truekai.tank.GameObject;

/**
 * @Author: xk
 * @Date: 2020/11/27 23:29
 * @Desc: 碰撞器
 */
public interface Collider {
    boolean collider(GameObject o1, GameObject o2, GameModel gameModel);
}
