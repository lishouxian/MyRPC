package com.xian.myrpc.customs;

import com.xian.myrpc.netty.NettyClient;
import com.xian.myrpc.publicinterface.HelloService;

/**
 * @Auther: lishouxian
 * @Date: 2020/11/25 16:37
 * @Description: ClientBootstrap
 */
public class ClientBootstrap {
    public static final String providerName = "hello#";


    public static void main(String[] args) {
        //创建一个消费者
        NettyClient customer = new NettyClient();
        HelloService service = (HelloService) customer.getBean(HelloService.class, providerName);
        System.out.println("对象创建完成");
        String res = service.hello("你好 dubbo");
        System.out.println(res);
    }
}
