package com.xian.myrpc2.server;

import com.xian.myrpc2.service.BlogService;
import com.xian.myrpc2.service.Impl.BlogServiceImpl;
import com.xian.myrpc2.service.Impl.UserServiceImpl;
import com.xian.myrpc2.service.UserService;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: lishouxian
 * @Date: 2020/11/26 14:35
 * @Description: TestServer
 */
public class TestServer {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        BlogService blogService = new BlogServiceImpl();

//        Map<String, Object> serviceProvide = new HashMap<>();
//        serviceProvide.put("com.ganghuan.myRPCVersion2.service.UserService",userService);
//        serviceProvide.put("com.ganghuan.myRPCVersion2.service.BlogService",blogService);
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.provideServiceInterface(userService);
        serviceProvider.provideServiceInterface(blogService);

        RPCServer RPCServer = new SimpleRPCRPCServer(serviceProvider.getInterfaceProvider());
        RPCServer.start(8899);
    }
}
