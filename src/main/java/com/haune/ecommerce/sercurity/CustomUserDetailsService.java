package com.haune.ecommerce.sercurity;

import com.haune.ecommerce.entity.SiteUser;
import com.haune.ecommerce.repository.SiteUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final SiteUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        SiteUser siteUser = userRepository.findByEmailAddress(email)
                .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy người dùng với email: " + email));

        return new User(siteUser.getEmailAddress(), siteUser.getPassword(), Collections.emptyList());
    }
}
