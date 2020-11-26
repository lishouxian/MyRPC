package com.xian.myrpc2.service.Impl;

import com.xian.myrpc2.service.UserService;
import com.xian.myrpc2.service.entity.User;

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

    @Override
    public Integer insertUserId(User user) {
        System.out.println("插入数据成功："+user);
        return 1;
    }
}
