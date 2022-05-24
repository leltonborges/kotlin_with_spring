package org.dev.com.api.security.filter

import org.dev.com.api.jwt.JWTUtil
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JWTAuthenticationFilter(
    private val jwtUtil: JWTUtil
) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val tokerBearer = request.getHeader("Authorization")
        val jwt = getTokenDetail(tokerBearer)
        if (jwtUtil.isValide(jwt)) {
            val authentication = jwtUtil.getAuthentication(jwt)
            SecurityContextHolder.getContext().authentication = authentication
        }
        filterChain.doFilter(request, response)
    }

    private fun getTokenDetail(tokerBearer: String?): String? {
        return tokerBearer?.let { t ->
            t.startsWith("Bearer ")
            t.substring(7, t.length)
        }
    }

}
