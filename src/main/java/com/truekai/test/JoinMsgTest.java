package com.truekai.test;

import com.truekai.tank.Dir;
import com.truekai.tank.Group;
import com.truekai.truekaiNettyTest.TankMsg;
import com.truekai.truekaiNettyTest.TankMsgDecoder;
import com.truekai.truekaiNettyTest.TankMsgEncoder;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

/**
 * @Author: xk
 * @Date: 2021/1/29 12:30 下午
 * @Desc: 对Decoder和Encoder做单元测试
 *
 * 结论：单元测试通过
 */
public class JoinMsgTest {

    @Test
    public void testDecoder() {
        EmbeddedChannel ch = new EmbeddedChannel();
        UUID id = UUID.randomUUID();
        TankMsg msg = new TankMsg(5, 10, Dir.DOWN, true, Group.BAD, id);
        ch.pipeline()
                .addLast(new TankMsgEncoder());

        ch.writeOutbound(msg);

        ByteBuf buf = (ByteBuf) ch.readOutbound();

        int x = buf.readInt();
        int y = buf.readInt();
        int dirOrdinal = buf.readInt();
        Dir dir = Dir.values()[dirOrdinal];
        boolean moving = buf.readBoolean();
        int groupOrdinal = buf.readInt();
        Group g = Group.values()[groupOrdinal];
        UUID uuid = new UUID(buf.readLong(), buf.readLong());

        assertEquals(5, x);
        assertEquals(10, y);
        assertEquals(Dir.DOWN, dir);
        assertEquals(true, moving);
        assertEquals(Group.BAD, g);
        assertEquals(id, uuid);
    }

    @Test
    public void testEncoder() {
        EmbeddedChannel ch = new EmbeddedChannel();
        UUID id = UUID.randomUUID();
        TankMsg msg = new TankMsg(5, 10, Dir.DOWN, true, Group.BAD, id);
        ch.pipeline()
                .addLast(new TankMsgDecoder());

        ByteBuf buf = Unpooled.buffer();
        byte[] bytes = msg.toBytes();
		buf.writeBytes(bytes);
		ch.writeInbound(buf.duplicate());

        TankMsg msgR = (TankMsg) ch.readInbound();

        assertEquals(5, msgR.x);
        assertEquals(10, msgR.y);
        assertEquals(Dir.DOWN, msgR.dir);
        assertEquals(true, msgR.moving);
        assertEquals(Group.BAD, msgR.group);
        assertEquals(id, msgR.id);

    }
}
