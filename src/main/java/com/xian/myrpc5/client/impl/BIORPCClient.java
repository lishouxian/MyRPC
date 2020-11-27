package com.xian.myrpc5.client.impl;

import com.xian.myrpc5.client.RPCClient;
import com.xian.myrpc5.register.ServiceRegister;
import com.xian.myrpc5.register.impl.ZkServiceRegister;
import com.xian.myrpc5.server.utils.RPCRequest;
import com.xian.myrpc5.server.utils.RPCResponse;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;


/**
 * @Auther: lishouxian
 * @Date: 2020/11/25 21:52
 * @Description: RPCClient
 */
@AllArgsConstructor
public class BIORPCClient implements RPCClient {
    private String host;
    private int port;
    private ServiceRegister serviceRegister;

    public BIORPCClient() {
        // 初始化注册中心，建立连接
        this.serviceRegister = new ZkServiceRegister();
    }

    @Override
    public RPCResponse sendRequest(RPCRequest request) {
        try {
            InetSocketAddress address = serviceRegister.serviceDiscovery(request.getInterfaceName());
            host = address.getHostName();
            port = address.getPort();

            // 发起一次Socket连接请求
            Socket socket = new Socket(host, port);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            System.out.println(request);
            objectOutputStream.writeObject(request);
            objectOutputStream.flush();

            RPCResponse response = (RPCResponse) objectInputStream.readObject();

            //System.out.println(response.getData());
            return response;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println();
            return null;
        }
    }

}

