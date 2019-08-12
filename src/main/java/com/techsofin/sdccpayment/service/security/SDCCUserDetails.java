package com.techsofin.sdccpayment.service.security;

import com.techsofin.sdccpayment.entity.User;
import com.techsofin.sdccpayment.entity.UserRole;
import com.techsofin.sdccpayment.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SDCCUserDetails implements UserDetails {

    private User user;

    public SDCCUserDetails() {
    }

    public SDCCUserDetails(User user) {
        this.user = user;
    }

    private final String DEFAULT_USER_ROLE = "ANONYMOUS";

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> grantedAuthorities = Arrays.asList(new SimpleGrantedAuthority(DEFAULT_USER_ROLE));

        List<UserRole> userRoles = this.user.getUserRoles();
        if (Objects.nonNull(userRoles)) {
            grantedAuthorities = userRoles.stream().map(userRole -> new SimpleGrantedAuthority(userRole.getName())).collect(Collectors.toList());
        }
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
