package net.lyncas.auth.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class JWTValidateFilter extends BasicAuthenticationFilter {

    public static final String HEADER_ATTRIBUTE = "Authorization";
    public static final String PREFIX_ATTRIBUTE = "Bearer ";

    public JWTValidateFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        String attribute = request.getHeader((HEADER_ATTRIBUTE));

        if (attribute == null) {
            chain.doFilter(request, response);
            return;
        }

        if(!attribute.startsWith(PREFIX_ATTRIBUTE)) {
            chain.doFilter(request, response);
            return;
        }

        String token = attribute.replace (PREFIX_ATTRIBUTE, "");
        UsernamePasswordAuthenticationToken authToken = getAuthToken(token);

        SecurityContextHolder.getContext().setAuthentication(authToken);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthToken(String token) {

        String user = null;
        try {
            user = JWT.require(Algorithm.HMAC512(JWTAuthFilter.PASSWORD_TOKEN))
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        if (user == null) {
            return null;
        }

        return new UsernamePasswordAuthenticationToken(user,null, new ArrayList<>());
    }
}
