package com.truekai.tank.chain;

import com.truekai.tank.GameObject;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: xk
 * @Date: 2020/11/28 1:51
 * @Desc:
 */
public class ColliderChain implements Collider {
    //不需要用下标值访问
    private List<Collider> list = new LinkedList<>();

    public ColliderChain() {
        add(new TankTankCollider());
        add(new BulletTankCollider());
    }

    //两个 collider直接连接也可以的
    public void add(Collider collider) {
        list.add(collider);
    }

    public void collider(GameObject o1, GameObject o2) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).collider(o1, o2);
        }
    }
}
