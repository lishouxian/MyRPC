package com.xian.myrpc2.server;



/**
 * @Auther: lishouxian
 * @Date: 2020/11/25 21:53
 * @Description: RPCServer
 */
public interface RPCServer {
    void start(int port);
    void stop();
}