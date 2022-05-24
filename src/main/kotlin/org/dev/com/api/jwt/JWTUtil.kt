package org.dev.com.api.jwt

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.lang.IllegalArgumentException
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

    fun isValide(jwt: String?): Boolean {
        return try {
            jwtClaims(jwt)
            true
        }catch (e: IllegalArgumentException){
            false
        }
    }

    private fun jwtClaims(jwt: String?) = Jwts.parser()
        .setSigningKey(secketKey.toByteArray())
        .parseClaimsJwt(jwt)

    fun getAuthentication(jwt: String?): Authentication {
        val username = jwtClaims(jwt).body.subject
        return UsernamePasswordAuthenticationToken(username,null, null)
    }
}