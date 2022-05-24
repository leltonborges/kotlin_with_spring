package org.dev.com.api.security.filter

import com.fasterxml.jackson.databind.ObjectMapper
import org.dev.com.api.dtos.Credencials
import org.dev.com.api.jwt.JWTUtil
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JWTLoginFilter(
    private val authManager: AuthenticationManager,
    private val jwtUtil: JWTUtil
) : UsernamePasswordAuthenticationFilter() {

    override fun attemptAuthentication(
        request: HttpServletRequest?,
        response: HttpServletResponse?
    ): Authentication {
        val (username, password) = ObjectMapper().readValue(request?.inputStream, Credencials::class.java)
        val authenticationToken = UsernamePasswordAuthenticationToken(username, password)

        return authManager.authenticate(authenticationToken)
    }

    override fun successfulAuthentication(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        chain: FilterChain?,
        authResult: Authentication?
    ) {
        val userName = (authResult?.principal as UserDetails).username
        val token = jwtUtil.generateToken(userName)
        response?.addHeader("Authorization", "Bearer $token")
        chain?.doFilter(request, response)
    }
}
