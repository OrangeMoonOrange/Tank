package com.truekai.tank.chain;

import com.truekai.tank.GameModel;
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
        //todo 应该把这些collider放到配置文件里面
        add(new TankTankCollider());
        add(new BulletTankCollider());
        add(new BulletWallCollider());
        add(new TankWallCollider());
    }

    //两个 collider直接连接也可以的
    public void add(Collider collider) {
        list.add(collider);
    }

    public boolean collider(GameObject o1, GameObject o2) {
        for (int i = 0; i < list.size(); i++)
            if (!list.get(i).collider(o1, o2)) return false;
        return true;
    }
}
