package com.sha.demo.security;

import com.sha.demo.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sa
 * @date 16.05.2021
 * @time 19:12
 */
@Slf4j
public class InternalApiAuthenticationFilter extends OncePerRequestFilter
{
    private final String accessKey;

    public InternalApiAuthenticationFilter(String accessKey)
    {
        this.accessKey = accessKey;
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request)
    {
        return !request.getRequestURI().startsWith("/api/internal");
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain)
            throws ServletException, IOException
    {
        try
        {
            String requestKey = SecurityUtils.extractAuthTokenFromRequest(request);

            if (requestKey == null || !requestKey.equals(accessKey))
            {
                log.warn("Internal key endpoint requested without/wrong key uri={}", request.getRequestURI());
                throw new RuntimeException("UNAUTHORIZED");
            }

            UserPrincipal user = UserPrincipal.createSuperUser();
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            //authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            //SecurityUtils.setUserInSecurityContext(user, request);
        }
        catch (Exception ex)
        {
            logger.error("Could not set user authentication in security context", ex);
            throw ex;
        }
        filterChain.doFilter(request, response);
    }
}
