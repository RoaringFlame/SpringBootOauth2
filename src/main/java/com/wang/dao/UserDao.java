package com.wang.dao;

import com.wang.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wangxiangyun on 2017/6/8.
 */
public interface UserDao extends JpaRepository<UserEntity,Integer> {
    UserEntity findByUsername(String username);
}
