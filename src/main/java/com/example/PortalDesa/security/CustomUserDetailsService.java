package com.example.PortalDesa.security;

import com.example.PortalDesa.model.Users;
import com.example.PortalDesa.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Sogumontar Hendra Simangunsong on 09/04/2020.
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UsersRepo userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        Users user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
                );

        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(String sku) {
        Users user = userRepository.findFirstBySku(sku);

        return UserPrincipal.create(user);
    }
}
