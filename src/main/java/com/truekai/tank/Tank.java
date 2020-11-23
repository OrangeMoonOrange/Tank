package com.truekai.tank;

import java.awt.*;
import java.util.Random;

/**
 * @Author: xk
 * @Date: 2020/10/15 20:10
 * @Desc: 定义坦克类
 */
public class Tank {
    private int x, y;
    private Dir dir = Dir.DOWN;
    private int SPEED = 1;
    private boolean moving = true;
    private boolean living = true;//是否还或者或者

    private TankFrame tf = null;
    public static int WIDTH = RessourceMange.tankU.getWidth();//宽度
    public static int HEIGHT = RessourceMange.tankU.getHeight();//高度

    private Group group = Group.BAD;

    private Random random = new Random();

    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
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

        if (this.group == Group.BAD && random.nextInt(10) > 8)
            this.fire();
        if (this.group == Group.BAD && random.nextInt(100) > 95)
            randomDir();
    }

    private void randomDir() {
        if(this.group==Group.GOOD) return;
        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void fire() {
        int bX = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        Bullet bullet = new Bullet(bX, bY, this.dir, this.group, this.tf);
        tf.MybulletList.add(bullet);
    }

    public void die() {
        this.living = false;
    }
}
