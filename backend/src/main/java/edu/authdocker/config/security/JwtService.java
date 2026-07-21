package edu.authdocker.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class JwtService {

    private final String SECRET = "FIAGDFBI92837298";

    public String generateToken(String email){
        Algorithm algorithm = Algorithm.HMAC256(SECRET);

        return JWT.create()
                .withIssuer("back-end")
                .withSubject(email)
                .withExpiresAt(LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00")))
                .sign(algorithm);
    }

    public String validateToken(String token){
        Algorithm algorithm = Algorithm.HMAC256(SECRET);

        try{
            String subject = JWT.require(algorithm)
                    .build()
                    .verify(token)
                    .getSubject();
            return subject;
        }catch (RuntimeException e){
            return "";
        }
    }

}
