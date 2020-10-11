package com.fernando.supermercado.domain.dto;

import lombok.Data;

/**
 * @author Fernando
 * @since 11/10/2020
 */
@Data
public class AuthenticationResponse {

    private String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }
}
