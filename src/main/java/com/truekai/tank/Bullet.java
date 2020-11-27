package com.truekai.tank;

import java.awt.*;
import java.util.Comparator;

/**
 * @Author: xk
 * @Date: 2020/11/21 22:56
 * @Desc: 子弹类
 */
public class Bullet extends GameObject {
    private int SPEED = 5;//速度
    private Dir dir;//方向
    private int x;//x位置
    private int y;//y位置
    public boolean live = true;//是否还活着  边界判断
    public static int WIDTH = RessourceMange.bulletD.getWidth();//宽度
    public static int HEIGHT = RessourceMange.bulletD.getHeight();//高度
    private Group group = Group.BAD;

    //子弹自己的长方形，用于碰撞检测
    Rectangle rectangle = new Rectangle();



    public Bullet(int x, int y, Dir dir, Group group) {
        this.dir = dir;
        this.x = x;
        this.y = y;
        this.group = group;

        //构造子弹自身的rectangle
        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;

        GameModel.getInstance().add(this);//每次新new出的子弹都添加进去
    }

    public void paint(Graphics g) {
        if (!live) {
            GameModel.getInstance().remove(this);
        }
        switch (dir) {
            case LEFT:
                g.drawImage(RessourceMange.bulletL, x, y, null);
                break;
            case UP:
                g.drawImage(RessourceMange.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(RessourceMange.bulletD, x, y, null);
                break;
            case RIGHT:
                g.drawImage(RessourceMange.bulletR, x, y, null);
                break;
        }
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
        //移动了就必须更新自己的rectangle的位置
        rectangle.x = this.x;
        rectangle.y = this.y;
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            live = false;
        }
    }

   public void die() {
        this.live = false;
    }

    public int getSPEED() {
        return SPEED;
    }

    public void setSPEED(int SPEED) {
        this.SPEED = SPEED;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
}
