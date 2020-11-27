package com.xian.myrpc5.client;

import com.xian.myrpc5.server.utils.RPCRequest;
import com.xian.myrpc5.server.utils.RPCResponse;


/**
 * @Auther: lishouxian
 * @Date: 2020/11/25 21:52
 * @Description: RPCClient
 */

public interface RPCClient {
    RPCResponse sendRequest(RPCRequest request);

}

