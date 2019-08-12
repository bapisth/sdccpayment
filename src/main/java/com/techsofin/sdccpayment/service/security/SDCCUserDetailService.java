package com.techsofin.sdccpayment.service.security;

import com.techsofin.sdccpayment.entity.User;
import com.techsofin.sdccpayment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SDCCUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (Objects.isNull(user))
            throw new UsernameNotFoundException(" user does not exists!!");
        return new SDCCUserDetails(user);
    }

}
