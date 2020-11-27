package com.truekai.tank;

import java.awt.*;

/**
 * @Author: xk
 * @Date: 2020/11/26 16:06
 * @Desc: 所有游戏物体得父类
 */
public abstract class GameObject {
    int x, y;

    public abstract void paint(Graphics g);
}
