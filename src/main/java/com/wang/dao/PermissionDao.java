package com.wang.dao;

import com.wang.domain.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by wangxiangyun on 2017/6/8.
 */
public interface PermissionDao extends JpaRepository<PermissionEntity,Integer> {
    @Query(value = " select p.*\n" +
            "        from user u\n" +
            "        LEFT JOIN user_role sru on u.id= sru.user_id\n" +
            "        LEFT JOIN role r on sru.role_id=r.id\n" +
            "        LEFT JOIN role_permisson spr on spr.role_id=r.id\n" +
            "        LEFT JOIN permission p on p.id =spr.permisson_id\n" +
            "        where u.id=?1",nativeQuery = true)
    List<PermissionEntity> findUserAllPermissions(int id);
}
