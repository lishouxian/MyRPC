package com.xian.myrpc5.server.impl;

import com.xian.myrpc5.register.ServiceRegister;
import com.xian.myrpc5.register.impl.ZkServiceRegister;
import com.xian.myrpc5.server.RPCServer;
import com.xian.myrpc5.server.ServiceProvider;
import com.xian.myrpc5.server.utils.WorkThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

/**
 * @Auther: lishouxian
 * @Date: 2020/11/26 14:36
 * @Description: SimpleRPCRPCServer
 */
public class BIORPCServer implements RPCServer {
    // 存着服务接口名-> service对象的map
    private Map<String, Object> serviceProvide;
    private ServiceRegister serviceRegister;

    public BIORPCServer(ServiceProvider serviceProvide){
        this.serviceRegister = new ZkServiceRegister();
    }

    public void start(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("服务端启动了");
            // BIO的方式监听Socket
            while (true){
                Socket socket = serverSocket.accept();
                // 开启一个新线程去处理
                new Thread(new WorkThread(socket,serviceProvide)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败");
        }
    }

    public void stop(){
    }
}
