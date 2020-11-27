package com.xian.myrpc5.service.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Auther: lishouxian
 * @Date: 2020/11/25 21:48
 * @Description: User
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private String userName;
    private Integer id;
    private Boolean sex;
}
