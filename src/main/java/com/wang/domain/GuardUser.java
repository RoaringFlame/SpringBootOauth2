package com.wang.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Created by wangxiangyun on 2017/6/8.
 */
public class GuardUser implements UserDetails {

    private String name;
    private String password;
    private List<GrantedAuthority> grantedAuthorities;


    public GuardUser(String name, String password, List<GrantedAuthority> grantedAuthorities) {
        this.name=name;
        this.password=password;
        this.grantedAuthorities=grantedAuthorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
