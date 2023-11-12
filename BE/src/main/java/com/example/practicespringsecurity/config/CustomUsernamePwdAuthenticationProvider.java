package com.example.practicespringsecurity.config;

import com.example.practicespringsecurity.model.Authority;
import com.example.practicespringsecurity.model.Customer;
import com.example.practicespringsecurity.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor
public class CustomUsernamePwdAuthenticationProvider implements AuthenticationProvider {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        List<Customer> customer = customerRepository.findByEmail(username);
        if(customer.size()>0){
            if(passwordEncoder.matches(pwd,customer.get(0).getPwd())) {
                return new UsernamePasswordAuthenticationToken(username, pwd, getGrantAuthorities(customer.get(0).getAuthorities()));
            } else {
                throw  new BadCredentialsException("Invaild password");
            }
        } else {
            throw new BadCredentialsException("no user registered");
        }
    }
    private List<GrantedAuthority> getGrantAuthorities(Set<Authority> authorities){
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for(Authority authority:authorities){
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
        }
        return grantedAuthorities;
    }
    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
