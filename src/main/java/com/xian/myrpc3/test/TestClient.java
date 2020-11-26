package com.xian.myrpc3.test;

import com.xian.myrpc3.client.RPCClient;
import com.xian.myrpc3.client.impl.NettyRPCClient;
import com.xian.myrpc3.service.BlogService;
import com.xian.myrpc3.service.entity.Blog;
import com.xian.myrpc3.service.UserService;
import com.xian.myrpc3.service.entity.User;
import com.xian.myrpc3.client.RPCClientProxy;
import com.xian.myrpc3.client.impl.BIORPCClient;

/**
 * @Auther: lishouxian
 * @Date: 2020/11/26 14:57
 * @Description: TestClient
 */
public class TestClient {
    public static void main(String[] args) {
        // 构建一个使用java Socket传输的客户端
        RPCClient rPCClient = new NettyRPCClient("127.0.0.1", 8899);
// 把这个客户端传入代理客户端
        RPCClientProxy rpcClientProxy = new RPCClientProxy(rPCClient);
// 代理客户端根据不同的服务，获得一个代理类， 并且这个代理类的方法以或者增强（封装数据，发送请求）
        UserService userService = rpcClientProxy.getProxy(UserService.class);
//// 调用方法
        User userByUserId = userService.getUserByUserId(10);
        System.out.println(userByUserId);
//
//        // 服务的方法2
//        User user = User.builder().userName("张三").id(100).sex(true).build();
//        Integer integer = userService.insertUserId(user);
//        System.out.println("向服务端插入数据："+integer);
        BlogService blogService = rpcClientProxy.getProxy(BlogService.class);
        Blog blogById = blogService.getBlogById(10000);
        System.out.println("从服务端得到的blog为：" + blogById);
    }
}
