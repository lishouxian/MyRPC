package com.xian.myrpc.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

/**
 * @Auther: lishouxian
 * @Date: 2020/11/25 16:16
 * @Description: NettyClientHandler
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter implements Callable {


    private ChannelHandlerContext context;
    private String result;
    private String para = "1111"; //客户端调用方法时传入的参数


    //连接后调用
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        context = ctx;
    }

    //收到消息后
    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        result = msg.toString();
        notify(); //唤醒等待的线程
    }

    public synchronized Object call() throws Exception {
        context.writeAndFlush(para);
        System.out.println("等待结果");
        //等待结果返回
        wait();
        return result;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    void setPara(String para){
        this.para = para;
    }

}
