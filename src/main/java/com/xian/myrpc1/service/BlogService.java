package com.xian.myrpc1.service;

import com.xian.myrpc1.service.entity.Blog;

/**
 * @Auther: lishouxian
 * @Date: 2020/11/25 22:05
 * @Description: BlogService
 */
public interface BlogService {
    Blog getBlogById(Integer id);
}
