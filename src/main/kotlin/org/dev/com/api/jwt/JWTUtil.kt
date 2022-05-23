package org.dev.com.api.jwt

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

@Component
class JWTUtil {
    @Value("\${jwt.secret}")
    private lateinit var secketKey: String

    private val expiration = 3600000

    fun generateToken(username: String): String? {
        return Jwts.builder().setSubject(username).setPayload(username)
            .setExpiration(Date(System.currentTimeMillis() + expiration))
            .signWith(SignatureAlgorithm.ES512, secketKey.toByteArray())
            .compact();
    }
}