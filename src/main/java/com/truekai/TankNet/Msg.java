package com.truekai.TankNet;

/**
 * @Author: xk
 * @Date: 2021/1/29 5:13 下午
 * @Desc:
 */
public abstract class Msg {
    public abstract void handle();
    public abstract byte[] toBytes();
}
