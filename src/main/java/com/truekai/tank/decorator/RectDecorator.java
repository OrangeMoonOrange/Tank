package com.truekai.tank.decorator;

import com.truekai.tank.GameObject;

import java.awt.*;

/**
 * @Author: xk
 * @Date: 2020/11/28 18:59
 * @Desc:
 */
public class RectDecorator extends GODecorator {

    public RectDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        this.x = go.x;//这部分是动态的 ，所以需要动态记录x y的位置
        this.y = go.y;
        go.paint(g);//画出需要装饰的物体
        Color c = g.getColor();
        g.setColor(Color.white);
        g.drawRect(super.go.x,super.go.y,super.go.getWidth()+2,super.go.getHeight()+2);
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
