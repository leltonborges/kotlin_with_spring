package org.dev.com.api.security

import org.dev.com.api.jwt.JWTUtil
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfiguration(
    private val userDetailsService: UserDetailsService,
    private val jtwUtil: JWTUtil
) : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        http?.cors()?.disable()
        http?.authorizeRequests()?.
//            antMatchers("/topico")?.hasAnyAuthority("ADMIN", "GERENTE")?.
//            antMatchers("/topico")?.hasAnyRole("ADMIN", "GERENTE")?.
            antMatchers("/login")?.permitAll()?.
            antMatchers("/h2-console/**", "/")?.permitAll()?.
        and()?.authorizeRequests()?.
            anyRequest()?.authenticated()?.
        and()
        http?.addFilterBefore(JWTLoginFilter(authManager = authenticationManager(), jtwUtil = jtwUtil), UsernamePasswordAuthenticationFilter().javaClass)
        http?.sessionManagement()?.sessionCreationPolicy(SessionCreationPolicy.STATELESS)?.
        and()?.formLogin()?.disable()?.httpBasic();
    }

    @Bean
    fun bCrypetPasswordEncoder(): BCryptPasswordEncoder{
        return BCryptPasswordEncoder()
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.userDetailsService(userDetailsService)?.passwordEncoder(bCrypetPasswordEncoder())
    }
}