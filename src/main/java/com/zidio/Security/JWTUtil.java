package com.zidio.Security;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {

    private final String secret = "zidioSecretKey";
    private final long expiration = 86400000;

    public String generateToken(String email , String role) 
    {
        return Jwts.builder().setSubject(email).claim("role" , role).setIssuedAt(new Date(System.currentTimeMillis()+expiration))
        .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public String getEmailFromToken(String token)
    {
        return getClaims(token).getSubject();
    }

    public Claims getClaims(String token)
    {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    public boolean validationToken(String token)
    {
        try {
            getClaims(token);
            return true;
        } catch (Exception e) 
        {
            return false;
        }
    }
}
