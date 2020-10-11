package com.fernando.supermercado.domain.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Servicio para menejar el ingreso a los metodos de la aplicación
 *
 * @author Fernando
 * @since 10/10/2020
 */
@Service
public class MarketUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("fernando", "{noop}platzi", new ArrayList<>());
    }
}
