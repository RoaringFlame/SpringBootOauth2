package com.wang.service.Impl;

import com.wang.config.MyGrantedAuthority;
import com.wang.dao.PermissionDao;
import com.wang.dao.UserDao;
import com.wang.domain.PermissionEntity;
import com.wang.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserDao userDao;
	@Autowired
	PermissionDao permissionDao;



	public UserDetails loadUserByUsername(String username) {
		UserEntity user = userDao.findByUsername(username);
		if (user != null) {
			List<PermissionEntity> permissionList = permissionDao.findUserAllPermissions(user.getId());
			List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
			for (PermissionEntity permission : permissionList) {
				if (permission != null && permission.getName() != null) {
					GrantedAuthority grantedAuthority = new MyGrantedAuthority(permission.getUrl(), permission.getMethod());
					grantedAuthorities.add(grantedAuthority);
				}
			}
			//添加默认权限
			GrantedAuthority tokenAuthority = new MyGrantedAuthority("/oauth/token","ALL");
			GrantedAuthority authorizeAuthority = new MyGrantedAuthority("/oauth/authorize","ALL");
			GrantedAuthority confirmAccessAuthority = new MyGrantedAuthority("/oauth/confirm_access","ALL");
			grantedAuthorities.add(tokenAuthority);
			grantedAuthorities.add(authorizeAuthority);
			grantedAuthorities.add(confirmAccessAuthority);
			return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
		} else {
			throw new UsernameNotFoundException("admin: " + username + " do not exist!");
		}
	}
}