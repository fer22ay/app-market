package com.fernando.supermercado.web.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Clase para generar el Json Web Token
 *
 * @author Fernando
 * @since 10/10/2020
 */
@Component
public class JWTUtil {

    /**
     * Constante para firmar nuestro Json web token
     */
    private static final String KEY = "pl4tz1";

    public String generateToken(UserDetails userDetails){

        return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, KEY).compact();
    }

    public boolean validateToken(String token, UserDetails userDetails){
        return userDetails.getUsername().equals(extractUsername(token)) && !isTokenExpired(token);
    }

    /**
     * Metodo para extraer el usuario que genero el token
     * @param token de tipo String
     * @return Nombre del usuario que genero el token
     */
    public String extractUsername(String token){
        return getClaims(token).getSubject();
    }

    /**
     * Metodo para validar si el token no a expirado.
     * @param token de tipo String
     * @return si token aún esta vigente.
     */
    public boolean isTokenExpired(String token){
        return getClaims(token).getExpiration().before(new Date());
    }

    /**
     * Metodo para obtener los datos del json web token
     * @param token de tipo String
     * @return cuerpo del json web token
     */
    private Claims getClaims(String token){
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
    }

}
