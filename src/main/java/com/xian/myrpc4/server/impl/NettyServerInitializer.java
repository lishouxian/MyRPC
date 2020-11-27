package com.xian.myrpc4.server.impl;

import com.xian.myrpc4.codec.JsonSerializer;
import com.xian.myrpc4.codec.MyDecode;
import com.xian.myrpc4.codec.MyEncode;
import com.xian.myrpc4.codec.ObjectSerializer;
import com.xian.myrpc4.server.ServiceProvider;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolver;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import lombok.AllArgsConstructor;

/**
 * @Auther: lishouxian
 * @Date: 2020/11/26 15:37
 * @Description: NettyServerInitializer
 */
@AllArgsConstructor
public class NettyServerInitializer extends ChannelInitializer<SocketChannel> {
    private ServiceProvider serviceProvider;
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        // 这里使用的还是java 序列化方式， netty的自带的解码编码支持传输这种结构
        pipeline.addLast(new MyDecode());
        pipeline.addLast(new MyEncode(new JsonSerializer()));

        System.out.println(serviceProvider);
        pipeline.addLast(new NettyRPCServerHandler(serviceProvider));
    }
}