package com.xian.myrpc4.client;

import com.xian.myrpc4.server.utils.RPCRequest;
import com.xian.myrpc4.server.utils.RPCResponse;


/**
 * @Auther: lishouxian
 * @Date: 2020/11/25 21:52
 * @Description: RPCClient
 */

public interface RPCClient {
    RPCResponse sendRequest(RPCRequest request);

}

