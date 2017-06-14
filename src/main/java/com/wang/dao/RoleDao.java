package com.wang.dao;

import com.wang.domain.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wangxiangyun on 2017/6/8.
 */
public interface RoleDao extends JpaRepository<RoleEntity,Integer> {
}
