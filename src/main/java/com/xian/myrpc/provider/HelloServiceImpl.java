package com.xian.myrpc.provider;

import com.xian.myrpc.publicinterface.HelloService;

/**
 * @Auther: lishouxian
 * @Date: 2020/11/25 15:54
 * @Description: HelloServiceImpl
 */
public class HelloServiceImpl  implements HelloService {
    public String hello(String msg) {
        System.out.println("收到客户端消息" + msg);
        if (msg != null){
            return "收到消息" + msg;
        }else{
            return "收到空消息";
        }
    }
}
