package com.xian.myrpc0.service;

import com.xian.myrpc0.entity.User;

/**
 * @Auther: lishouxian
 * @Date: 2020/11/25 21:50
 * @Description: UserService
 */
public interface UserService {
    User getUserByUserId(Integer id);
}
