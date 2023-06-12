package com.loan.application.system.utilities;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.Map;

import static com.loan.application.system.utilities.Constants.ISSUER;

@Service
@RequiredArgsConstructor
public class JwtUtils {
    @Value("${Jwt_Secret_Key}")
    private String jwtSecretKey;
    @Value("${access_expiration}")
    private long accessExpiration;
    @Value("${refresh_expiration}")
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
    public String generateAccessToken(
            Map<String, Object> claims,
            String email
    ) {
        return generateToken(claims, email, accessExpiration);
    }
    private String generateToken(
            Map<String, Object> claims,
            String email,
            long expirationTime
    ) {
        return Jwts.builder()
                .setIssuer(ISSUER)
                .setIssuedAt(Date.from(Instant.now()))
                .setClaims(claims)
                .setExpiration(Date.from(
                        Instant.now()
                                .plusSeconds(
                                        expirationTime)))
                .signWith(SignatureAlgorithm.HS512, signKey())
                .setSubject(email)
                .compact();
    }

}
