package com.xian.myrpc5.register;

import java.net.InetSocketAddress;

/**
 * @Auther: lishouxian
 * @Date: 2020/11/27 15:43
 * @Description: ServiceRegister
 */
public interface ServiceRegister {
    void register(String serviceName, InetSocketAddress serverAddress);
    InetSocketAddress serviceDiscovery(String serviceName);
}
