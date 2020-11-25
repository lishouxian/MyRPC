package com.xian.myrpc.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @Auther: lishouxian
 * @Date: 2020/11/25 15:58
 * @Description: NettyServer 完成对Netty的初始化和启动
 */
public class NettyServer {
    public static void  startServer(String hostname,int port) {
        startServer0(hostname,port);
        System.out.println("服务提供方已经启动");
    }


    private static void startServer0(String hostname,int port){
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workgroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootStrap = new ServerBootstrap();
            serverBootStrap.group(bossGroup,workgroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            pipeline.addLast(new StringDecoder());
                            pipeline.addLast(new StringEncoder());
                            pipeline.addLast(new NettyServerHandler()); //业务处理
                        }
                    });
            System.out.println("服务器在准备");
            ChannelFuture channelFuture = serverBootStrap.bind(hostname, port).sync();
            System.out.println("服务器准备好了");
            channelFuture.channel().closeFuture().sync();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            workgroup.shutdownGracefully();
        }


    }
}
