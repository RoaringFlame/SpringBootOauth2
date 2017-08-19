package com.wang.service.security;

import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class IMetadataSourceService implements FilterInvocationSecurityMetadataSource {

    @Override
    public Collection<org.springframework.security.access.ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        final HttpServletRequest request = ((FilterInvocation) object).getRequest();
        Set<org.springframework.security.access.ConfigAttribute> allAttributes = new HashSet<>();
        org.springframework.security.access.ConfigAttribute configAttribute = new IConfigAttribute(request);
        allAttributes.add(configAttribute);
        return allAttributes;
    }

    @Override
    public Collection<org.springframework.security.access.ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
