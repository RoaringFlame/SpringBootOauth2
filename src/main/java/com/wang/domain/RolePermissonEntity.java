package com.wang.domain;

import javax.persistence.*;

/**
 * Created by wangxiangyun on 2017/6/8.
 */
@Entity
@Table(name = "role_permisson", schema = "test", catalog = "")
public class RolePermissonEntity {
    private int id;
    private Integer roleId;
    private Integer permissonId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "role_id")
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "permisson_id")
    public Integer getPermissonId() {
        return permissonId;
    }

    public void setPermissonId(Integer permissonId) {
        this.permissonId = permissonId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolePermissonEntity that = (RolePermissonEntity) o;

        if (id != that.id) return false;
        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;
        if (permissonId != null ? !permissonId.equals(that.permissonId) : that.permissonId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        result = 31 * result + (permissonId != null ? permissonId.hashCode() : 0);
        return result;
    }
}
