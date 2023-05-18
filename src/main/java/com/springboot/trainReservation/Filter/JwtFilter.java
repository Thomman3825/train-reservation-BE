package com.springboot.trainReservation.Filter;

import com.springboot.trainReservation.Services.CustomUserDetailService;
import com.springboot.trainReservation.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class JwtFilter extends OncePerRequestFilter{

    @Autowired
    JwtUtil jwtUtill;

    @Autowired
    CustomUserDetailService customUserDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        String token = null;
        String userName = null;
        // Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJua2RlYnVnIiwiZXhwIjoxNjU5MzY2Mzc4LCJpYXQiOjE2NTkzMzAzNzh9.b55YX9u4uAtg5HqtaNNJBQoQirrxjmm4_sn1pW1_QH8
        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            userName = jwtUtill.extractUsername(token);
        }

        validatingUserToken(userName, token, request);

        filterChain.doFilter(request,response);

    }

    private void validatingUserToken(String user_name, String token, HttpServletRequest request) {

        if(user_name != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = customUserDetailService.loadUserByUsername(user_name);

            if(jwtUtill.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails,
                                null,userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder
                        .getContext()
                        .setAuthentication(usernamePasswordAuthenticationToken);
            }

        }
    }

}
