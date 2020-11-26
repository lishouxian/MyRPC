package com.xian.myrpc3.test;

import com.xian.myrpc3.server.RPCServer;
import com.xian.myrpc3.server.ServiceProvider;
import com.xian.myrpc3.server.impl.BIORPCServer;
import com.xian.myrpc3.server.impl.NettyRPCServer;
import com.xian.myrpc3.service.Impl.BlogServiceImpl;
import com.xian.myrpc3.service.Impl.UserServiceImpl;
import com.xian.myrpc3.service.UserService;
import com.xian.myrpc3.service.BlogService;

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
