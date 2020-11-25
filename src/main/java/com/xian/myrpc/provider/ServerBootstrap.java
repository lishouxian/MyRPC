package com.xian.myrpc.provider;

import com.xian.myrpc.netty.NettyServer;

/**
 * @Auther: lishouxian
 * @Date: 2020/11/25 15:57
 * @Description: ServerBootStrap
 */
//启动一个服务提供者
public class ServerBootstrap {

    public static void main(String[] args) {
        NettyServer.startServer("127.0.0.1",8090);
    }
}
