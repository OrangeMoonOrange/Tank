package com.truekai.tank;

import java.awt.*;

/**
 * @Author: xk
 * @Date: 2020/11/21 22:56
 * @Desc: 子弹类
 */
public class Bullet {
    private static final int SPEED = 1;//速度
    private Dir dir;//方向
    private int x;//x位置
    private int y;//y位置

    public Bullet(int x, int y, Dir dir) {
        this.dir = dir;
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x, y, 50, 50);
        g.setColor(c);
        move();
    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
        }
    }
}
