package com.xian.myrpc4.test;

import com.xian.myrpc4.server.RPCServer;
import com.xian.myrpc4.server.ServiceProvider;
import com.xian.myrpc4.server.impl.NettyRPCServer;
import com.xian.myrpc4.service.BlogService;
import com.xian.myrpc4.service.Impl.BlogServiceImpl;
import com.xian.myrpc4.service.Impl.UserServiceImpl;
import com.xian.myrpc4.service.UserService;

/**
 * @Auther: lishouxian
 * @Date: 2020/11/26 14:35
 * @Description: TestServer
 */
public class TestServer {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        BlogService blogService = new BlogServiceImpl();
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.provideServiceInterface(userService);
        serviceProvider.provideServiceInterface(blogService);

        RPCServer RPCServer = new NettyRPCServer(serviceProvider);
        RPCServer.start(8899);

    }
}
