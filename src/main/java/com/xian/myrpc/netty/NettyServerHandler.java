package com.xian.myrpc.netty;

import com.xian.myrpc.provider.HelloServiceImpl;
import com.xian.myrpc.publicinterface.HelloService;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Auther: lishouxian
 * @Date: 2020/11/25 16:06
 * @Description: NettyServerHandler
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        //获取客户端发送的消息,并进行调用
        System.out.println("msg=" + msg);
        //需要定义一个协议:hello#你好
        if (msg.toString().startsWith("hello#")){
            String result = new HelloServiceImpl().hello(msg.toString().substring(6));
            ctx.writeAndFlush(result);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
