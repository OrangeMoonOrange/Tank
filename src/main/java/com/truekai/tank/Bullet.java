package com.truekai.tank;

import java.awt.*;

/**
 * @Author: xk
 * @Date: 2020/11/21 22:56
 * @Desc: 子弹类
 */
public class Bullet {
    private int SPEED = 5;//速度
    private Dir dir;//方向
    private int x;//x位置
    private int y;//y位置
    private boolean live = true;//是否还活着  边界判断
    private TankFrame tf;
    public static int WIDTH = RessourceMange.bulletD.getWidth();//宽度
    public static int HEIGHT = RessourceMange.bulletD.getHeight();//高度
    private Group group = Group.BAD;

    public Bullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.dir = dir;
        this.x = x;
        this.y = y;
        this.tf = tf;
        this.group = group;
    }

    public void paint(Graphics g) {
        if (!live) {
            this.tf.MybulletList.remove(this);
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
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            live = false;
        }
    }

    public void collidewith(Tank tank1) {
        if (this.group == tank1.getGroup()) return;

        Rectangle bullet = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
        Rectangle tank = new Rectangle(tank1.getX(), tank1.getY(), tank1.getWIDTH(), tank1.getHEIGHT());

        if (bullet.intersects(tank)) {
            this.die();
            tank1.die();
            int ex = tank1.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
            int ey = tank1.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
            tf.explodes.add(new Explode(ex, ey, tf));
        }
    }

    private void die() {
        this.live = false;
    }

    public int getSPEED() {
        return SPEED;
    }

    public void setSPEED(int SPEED) {
        this.SPEED = SPEED;
    }
}
