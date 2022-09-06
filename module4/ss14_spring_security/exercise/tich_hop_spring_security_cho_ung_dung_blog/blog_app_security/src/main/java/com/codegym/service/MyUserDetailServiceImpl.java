package com.codegym.service;

import com.codegym.model.AppUser;
import com.codegym.model.MyUserDetail;
import com.codegym.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MyUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private AppUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findByUserName(username);

        if (appUser == null) {
            throw new UsernameNotFoundException("user name: " + username + "not found");
        }
        return new MyUserDetail(appUser);
    }
}
