package com.xian.myrpc5.service;

import com.xian.myrpc5.service.entity.Blog;

/**
 * @Auther: lishouxian
 * @Date: 2020/11/25 22:05
 * @Description: BlogService
 */
public interface BlogService {
    Blog getBlogById(Integer id);
}
