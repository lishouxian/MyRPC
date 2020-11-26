package com.xian.myrpc2.service;

import com.xian.myrpc2.service.entity.User;

/**
 * @Auther: lishouxian
 * @Date: 2020/11/25 21:50
 * @Description: UserService
 */
public interface UserService {
    User getUserByUserId(Integer id);
    Integer insertUserId(User user);
}
