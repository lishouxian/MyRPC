package com.xian.myrpc2.service;

import com.xian.myrpc2.service.entity.Blog;

/**
 * @Auther: lishouxian
 * @Date: 2020/11/25 22:05
 * @Description: BlogService
 */
public interface BlogService {
    Blog getBlogById(Integer id);
}
