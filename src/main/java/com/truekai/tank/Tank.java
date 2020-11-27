package com.truekai.tank;


import com.truekai.tank.fireStrategy.FireStrategy;

import java.awt.*;
import java.util.Random;

/**
 * @Author: xk
 * @Date: 2020/10/15 20:10
 * @Desc: 定义坦克类
 */
public class Tank extends GameObject {
    public int x, y;
    public Dir dir ;
    private int SPEED = 1;
    private boolean moving = true;
    private boolean living = true;//是否还或者或者

    public static int WIDTH = RessourceMange.tankU.getWidth();//宽度
    public static int HEIGHT = RessourceMange.tankU.getHeight();//高度

    public Group group ;

    private Random random = new Random();
    //坦克自己的长方形，用于碰撞检测
    Rectangle rectangle = new Rectangle();

    public FireStrategy fs;


    public GameModel gameModel;

    public Tank(int x, int y, Dir dir, Group group, GameModel gameModel) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.gameModel = gameModel;
        this.group = group;

        //构造子弹自身的rectangle
        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;
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
            gameModel.tanks.remove(this);
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


        if (this.group == Group.BAD && random.nextInt(10) > 8) {
            this.fire();
        }
        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            randomDir();
        }

        boundcheck();

        //移动了就必须更新自己的rectangle的位置
        rectangle.x = this.x;
        rectangle.y = this.y;
    }

    //边界检测
    private void boundcheck() {
        if (this.x < 2) {
            x = 2;
        }
        if (this.y < 28) {
            y = 28;
        }
        if (this.x > TankFrame.GAME_WIDTH - Tank.WIDTH) {
            x = TankFrame.GAME_WIDTH - Tank.WIDTH;
        }
        if (this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT) {
            y = TankFrame.GAME_HEIGHT - Tank.HEIGHT;
        }
    }

    private void randomDir() {
        if (this.group == Group.GOOD) return;
        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void fire() {
        int bX = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        gameModel.MybulletList.add(new Bullet(bX, bY, this.dir, this.group, gameModel));
//        fs.fire(this);
    }

    public void die() {
        this.living = false;
    }
}
