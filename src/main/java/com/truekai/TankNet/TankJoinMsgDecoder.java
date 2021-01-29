package com.truekai.TankNet;

import java.util.List;
import java.util.UUID;

import com.truekai.tank.Dir;
import com.truekai.tank.Group;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class TankJoinMsgDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < 33) return;//TCP 拆包 粘包问题
        //需要计算tankMsg 的长度是多少？

        //如果长度不固定，该如何处理呢？

        //需要设定 也就是消息的长度等信息 消息头 消息体 校验码

        TankJoinMsg tankJoinMsg = new TankJoinMsg();
        tankJoinMsg.x = in.readInt();
        tankJoinMsg.y = in.readInt();
        tankJoinMsg.dir = Dir.values()[in.readInt()];
        tankJoinMsg.moving = in.readBoolean();
        tankJoinMsg.group = Group.values()[in.readInt()];
        tankJoinMsg.id = new UUID(in.readLong(), in.readLong());
        out.add(tankJoinMsg);


    }

}
