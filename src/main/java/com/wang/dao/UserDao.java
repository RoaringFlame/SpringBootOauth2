package com.wang.dao;

import com.wang.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/2/11 0011.
 */
public interface UserDao  extends JpaRepository<UserEntity,Integer> {
    UserEntity findByname(String username);
}
