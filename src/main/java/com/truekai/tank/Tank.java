package com.truekai.tank;

import java.awt.*;

/**
 * @Author: xk
 * @Date: 2020/10/15 20:10
 * @Desc: 定义坦克类
 */
public class Tank {
    private int x, y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 5;
    private boolean moving = false;
    private boolean living = true;
    private TankFrame tf = null;
    public int WIDTH = RessourceMange.tankU.getWidth();//宽度
    public int HEIGHT = RessourceMange.tankU.getHeight();//高度

    public Tank(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public void setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics g) {
        if (!living) {
            tf.tanks.remove(this);
        }
        switch (dir) {
            case LEFT:
                g.drawImage(RessourceMange.tankL, x, y, null);
                break;
            case UP:
                g.drawImage(RessourceMange.tankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(RessourceMange.tankD, x, y, null);
                break;
            case RIGHT:
                g.drawImage(RessourceMange.tankR, x, y, null);
                break;
        }

        move();
    }

    private void move() {
        if (!moving) return;
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

    public void fire() {
        Bullet bullet = new Bullet(this.x, this.y, this.dir, this.tf);
        tf.MybulletList.add(bullet);
    }

    public void die() {
        this.living = false;
    }
}
