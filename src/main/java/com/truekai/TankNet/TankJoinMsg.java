package com.truekai.TankNet;

import com.truekai.tank.Dir;
import com.truekai.tank.Group;
import com.truekai.tank.Tank;
import com.truekai.tank.TankFrame;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.UUID;

public class TankJoinMsg extends Msg {
    public int x, y;
    public Dir dir;
    public boolean moving;
    public Group group;
    public UUID id;


    public TankJoinMsg() {

    }

    public TankJoinMsg(int x, int y, Dir dir, boolean moving, Group group, UUID id) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.moving = moving;
        this.group = group;
        this.id = id;
    }

    public TankJoinMsg(Tank tank) {
        x = tank.getX();
        y = tank.getY();
        dir = tank.getDir();
        group = tank.getGroup();
        id = tank.getId();
        moving = tank.isMoving();
    }


    @Override
    public byte[] toBytes() {
        ByteArrayOutputStream baos = null;
        DataOutputStream dos = null;
        byte[] bytes = null;

        baos = new ByteArrayOutputStream();
        dos = new DataOutputStream(baos);
        try {
            dos.writeInt(x);
            dos.writeInt(y);
            dos.writeInt(dir.ordinal());
            dos.writeBoolean(moving);
            dos.writeInt(group.ordinal());
            dos.writeLong(id.getMostSignificantBits());
            dos.writeLong(id.getLeastSignificantBits());
            dos.flush();
            bytes = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bytes;
    }

    @Override
    public String toString() {
        return "TankMsg{" +
                "x=" + x +
                ", y=" + y +
                ", dir=" + dir +
                ", moving=" + moving +
                ", group=" + group +
                ", id=" + id +
                '}';
    }

    //消息 如何处理
    @Override
    public void handle() {
        if (this.id.equals(TankFrame.INSTANCE.getMainTank().getId())
                || TankFrame.INSTANCE.findByUUID(this.id) != null) return;

        System.out.println(this);
        Tank t = new Tank(this);
        TankFrame.INSTANCE.addTank(t);

        Client.INSTANCE.send(new TankJoinMsg(TankFrame.INSTANCE.getMainTank()));//然后新人看到老人的状态
    }
}