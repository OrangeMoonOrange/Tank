package com.truekai.tank.decorator;

import com.truekai.tank.GameObject;

import java.awt.*;

/**
 * @Author: xk
 * @Date: 2020/11/28 18:58
 * @Desc:
 */
public abstract class GODecorator extends GameObject {
    public GameObject go;//需要装饰的GameObject

    public GODecorator(GameObject go) {
        this.go = go;
    }

    @Override
    public abstract void paint(Graphics g);
}
