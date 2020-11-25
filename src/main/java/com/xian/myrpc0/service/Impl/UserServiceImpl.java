package com.xian.myrpc0.service.Impl;

import com.xian.myrpc0.entity.User;
import com.xian.myrpc0.service.UserService;

import java.util.Random;
import java.util.UUID;

/**
 * @Auther: lishouxian
 * @Date: 2020/11/25 21:51
 * @Description: UserServiceImpl
 */
public class UserServiceImpl implements UserService {
    @Override
    public User getUserByUserId(Integer id) {
        System.out.println("客户端查询了"+id+"的用户");
        // 模拟从数据库中取用户的行为
        Random random = new Random();
        User user = User.builder().userName(UUID.randomUUID().toString())
                .id(id)
                .sex(random.nextBoolean()).build();
        return user;

    }
}
