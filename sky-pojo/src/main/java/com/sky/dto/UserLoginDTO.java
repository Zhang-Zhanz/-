package com.sky.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * C端用户登录
 */

/**
 * Serializable 是标记接口，让对象具备 “转字节流 / 还原” 的能力；
 * DTO 类实现它，主要为了网络传输、缓存存储、分布式场景；
 */
@Data
public class UserLoginDTO implements Serializable {

    private String code;

}
