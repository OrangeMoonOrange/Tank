package com.truekai.tank;

import java.awt.*;

/**
 * @Author: xk
 * @Date: 2020/11/26 16:06
 * @Desc: 所有游戏物体得父类
 */
public abstract class GameObject {
    public int x, y;

    public abstract void paint(Graphics g);

    public abstract int getWidth();

    public abstract int getHeight();
}
