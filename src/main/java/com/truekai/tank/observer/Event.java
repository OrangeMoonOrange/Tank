package com.truekai.tank.observer;

/**
 * @Author: xk
 * @Date: 2020/11/29 12:33
 * @Desc:
 */
public abstract class Event<T> {
    abstract T getSource();//获取事件源对象

}
