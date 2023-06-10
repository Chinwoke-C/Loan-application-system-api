package com.loan.application.system.userManagement.security;

import com.loan.application.system.exceptions.userManagement.UserNotFoundException;
import com.loan.application.system.userManagement.data.model.User;
import com.loan.application.system.userManagement.data.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
        return new AuthenticatedUser(user);
    }
}
