package com.xian.myrpc5.test;

import com.xian.myrpc5.server.RPCServer;
import com.xian.myrpc5.server.ServiceProvider;
import com.xian.myrpc5.server.impl.NettyRPCServer;
import com.xian.myrpc5.service.BlogService;
import com.xian.myrpc5.service.Impl.BlogServiceImpl;
import com.xian.myrpc5.service.Impl.UserServiceImpl;
import com.xian.myrpc5.service.UserService;

/**
 * @Auther: lishouxian
 * @Date: 2020/11/26 14:35
 * @Description: TestServer
 */
public class TestServer {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        BlogService blogService = new BlogServiceImpl();
        // 这里重用了服务暴露类，顺便在注册中心注册，实际上应分开，每个类做各自独立的事
        ServiceProvider serviceProvider = new ServiceProvider("127.0.0.1", 8899);
        serviceProvider.provideServiceInterface(userService);
        serviceProvider.provideServiceInterface(blogService);

        RPCServer RPCServer = new NettyRPCServer(serviceProvider);
        RPCServer.start(8899);

    }
}
