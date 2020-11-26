package com.xian.myrpc2.client;

import com.xian.myrpc2.service.BlogService;
import com.xian.myrpc2.service.UserService;
import com.xian.myrpc2.service.entity.Blog;
import com.xian.myrpc2.service.entity.User;


/**
 * @Auther: lishouxian
 * @Date: 2020/11/25 21:52
 * @Description: RPCClient
 */

public class RPCClient {
    public static void main(String[] args) {

        ClientProxy clientProxy = new ClientProxy("127.0.0.1", 8899);
        UserService proxy = clientProxy.getProxy(UserService.class);

        // 服务的方法1
        User userByUserId = proxy.getUserByUserId(10);
        System.out.println("从服务端得到的user为：" + userByUserId);
        // 服务的方法2
        User user = User.builder().userName("张三").id(100).sex(true).build();
        Integer integer = proxy.insertUserId(user);
        System.out.println("向服务端插入数据："+integer);
        BlogService blogService = clientProxy.getProxy(BlogService.class);
        Blog blogById = blogService.getBlogById(10000);
        System.out.println("从服务端得到的blog为：" + blogById);

    }
}

