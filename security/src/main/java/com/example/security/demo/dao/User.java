package com.example.security.demo.dao;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class User implements UserDetails {
    private Integer id;
    private String userName;
    private String password;
    private Boolean enable;
    private Boolean locked;
    private List<Role> roles;

    // 实现方法


    // 获取当前对象的权限信息

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities=new ArrayList<>();
        for(Role role:roles){
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    //获取用户名

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    // 当前账户是否未过期

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 当前账户是否未锁定

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    // 当前账户密码是否未过期

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 当前账户是否可用

    @Override
    public boolean isEnabled() {
        return enable;
    }

    // 自动生成的get set 方法

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
