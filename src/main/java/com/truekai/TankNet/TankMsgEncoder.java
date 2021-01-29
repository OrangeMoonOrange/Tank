package com.truekai.TankNet;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class TankMsgEncoder extends MessageToByteEncoder<TankMsg> {


    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, TankMsg tankMsg, ByteBuf byteBuf) throws Exception {
        byteBuf.writeBytes(tankMsg.toBytes());
    }
}
