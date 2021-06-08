package com.sha.demo.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sa
 * @date 14.05.2021
 * @time 23:23
 */
public class JwtAuthorizationFilter extends OncePerRequestFilter
{

    @Autowired
    private IJwtProvider jwtTokenProvider;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request)
    {
        // internal api endpoints have their own auth filter
        String uri = request.getRequestURI();
        return uri.startsWith("/api/internal");
                //|| (uri.startsWith("/api/book") && HttpMethod.GET.name().equals(request.getMethod()));
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    {
        Authentication authentication = jwtTokenProvider.getAuthentication(request);

        if(authentication != null && jwtTokenProvider.validateToken(request))
        {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }
}
