package com.truekai.tank.decorator;

import com.truekai.tank.GameObject;

import java.awt.*;

/**
 * @Author: xk
 * @Date: 2020/11/28 18:59
 * @Desc:
 */
public class LineDecorator extends GODecorator {

    public LineDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        this.x = go.x;
        this.y = go.y;
        go.paint(g);//画出需要装饰的物体
        Color c = g.getColor();
        g.setColor(Color.white);
        g.drawLine(super.go.x,super.go.y,super.go.x+super.go.getWidth()+2,super.go.y+super.go.getHeight()+2);
        g.setColor(c);
    }

    @Override
    public int getWidth() {
        return super.go.getWidth();
    }

    @Override
    public int getHeight() {
        return super.go.getHeight();
    }
}
