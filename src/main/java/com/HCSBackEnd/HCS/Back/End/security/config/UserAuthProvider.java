package com.HCSBackEnd.HCS.Back.End.security.config;

import com.HCSBackEnd.HCS.Back.End.dto.PatientDto;
import com.HCSBackEnd.HCS.Back.End.service.PatientService;
import com.HCSBackEnd.HCS.Back.End.service.impl.PatientServiceImpl;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Base64;
import java.util.Collections;

@RequiredArgsConstructor
@Component
public class UserAuthProvider {

    private final PatientService patientService;
    //TODO: Need to fix the value error, it gives an error
    //@Value("${jwt.secret}")
    private String secretKey = "2rfgr";



    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(String login) {
        Date now = new Date(System.currentTimeMillis());
        Date validity = new Date(now.getTime() + 3_600_000);

        return JWT.create()
                .withIssuer(login)
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .sign(Algorithm.HMAC256(secretKey));
    }

    public Authentication validateToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey))
                .build();
        DecodedJWT decoded = verifier.verify(token);
        // TODO: Needs to be fixed for patient and doctors
        PatientDto user = new PatientDto();
        return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
    }

}
