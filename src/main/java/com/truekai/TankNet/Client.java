package com.truekai.TankNet;

import com.truekai.tank.Dir;
import com.truekai.tank.Group;
import com.truekai.tank.Tank;
import com.truekai.tank.TankFrame;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.ReferenceCountUtil;

import java.util.UUID;

public class Client {

    private Channel channel = null;

    public static final Client INSTANCE = new Client();

    public void connect() {

        EventLoopGroup group = new NioEventLoopGroup(1);

        Bootstrap b = new Bootstrap();

        try {
            ChannelFuture f = b.group(group).channel(NioSocketChannel.class)
                    .handler(new ClientChannelInitializer())
                    .connect("localhost", 8888);

            f.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if (!future.isSuccess()) {
                        System.out.println("not connected!");
                    } else {
                        System.out.println("connected!");
                        // initialize the channel
                        channel = future.channel();
                    }
                }
            });

            f.sync();
            // wait until close
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

    public void send(String msg) {
        ByteBuf buf = Unpooled.copiedBuffer(msg.getBytes());
        channel.writeAndFlush(buf);
    }

    public static void main(String[] args) throws Exception {
        Client.INSTANCE.connect();
    }

    public void closeConnect() {
        this.send("_bye_");
        //channel.close();
    }
}

class ClientChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline()
                .addLast(new TankMsgDecoder())//客户端是的两边都需要处理的 ，所以双向编码和解码
                .addLast(new TankMsgEncoder())
                .addLast(new ClientHandler());
    }

}

//因为 这里只处理 TankMsg这一种 消息 ，所以 使用这个
class ClientHandler extends SimpleChannelInboundHandler<TankMsg> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TankMsg tankMsg) throws Exception {
        System.out.println(tankMsg);

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        ctx.writeAndFlush(new TankMsg(TankFrame.INSTANCE.getMainTank()));//初始化之后 会把自己的状态写出去
    }
}

//class ClientHandler extends ChannelInboundHandlerAdapter {
//
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        ByteBuf buf = null;
//        try {
//            buf = (ByteBuf) msg;
//            byte[] bytes = new byte[buf.readableBytes()];
//            buf.getBytes(buf.readerIndex(), bytes);
//            String msgAccepted = new String(bytes);
////			ClientFrame.INSTANCE.updateText(msgAccepted);
//            // System.out.println(buf);
//            // System.out.println(buf.refCnt());
//        } finally {
//            if (buf != null)
//                ReferenceCountUtil.release(buf);
//            // System.out.println(buf.refCnt());
//        }
//    }
//
//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        ctx.writeAndFlush(new TankMsg(TankFrame.INSTANCE.getMainTank()));//初始化之后 会把自己的状态写出去
//    }
//
//}
