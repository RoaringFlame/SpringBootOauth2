package com.wang.service.security;

import org.springframework.security.core.GrantedAuthority;

public class PermissionGrantedAuthority implements GrantedAuthority {

    private String url;
    private String method;

    public PermissionGrantedAuthority(String url,String method){
        this.url = url;
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String getAuthority() {
        return this.url + ";"+this.method;
    }
}
