package com.truekai.tank;

import java.awt.*;

/**
 * @Author: xk
 * @Date: 2020/11/22 18:57
 * @Desc: 爆炸
 */
public class Explode extends GameObject {
    public static int WIDTH = RessourceMange.explodes[0].getWidth();
    public static int HEIGHT = RessourceMange.explodes[0].getHeight();

    private int x, y;

    private boolean living = true;
    TankFrame tf = null;

    public GameModel gameModel;

    private int step = 0;//画到第几步了

    public Explode(int x, int y, GameModel gameModel) {
        this.x = x;
        this.y = y;
        this.gameModel = gameModel;
    }


    public void paint(Graphics g) {

        g.drawImage(RessourceMange.explodes[step++], x, y, null);

        if (step >= RessourceMange.explodes.length) {
            step = 0;
            gameModel.remove(this);
        }
    }
}
