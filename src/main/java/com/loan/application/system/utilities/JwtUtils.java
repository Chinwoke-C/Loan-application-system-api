package com.loan.application.system.utilities;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.TextCodec;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtUtils {
    @Value("${Jwt_Secret_Key}")
    private String jwtSecretKey;
    @Value("${access_expiration}")
    private long accessExpiration;
    @Value("${access_expiration}")
    private long refreshExpiration;

    public boolean validateToken(String token) {
        try{
            Jwts.parser()
                    .setSigningKey(signKey())
                    .parseClaimsJws(token);
            return true;
        }catch(JwtException e){
            return false;
        }
    }

    private byte[] signKey() {
        return TextCodec.BASE64.decode(jwtSecretKey);
    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(signKey())
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
