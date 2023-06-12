package com.loan.application.system.userManagement.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loan.application.system.utilities.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static com.loan.application.system.utilities.Constants.BEARER;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Slf4j
@Component
@AllArgsConstructor
public class UserAuthorizationFilter extends OncePerRequestFilter {

    private final UserDetailsService userDetailsService;
    private final JwtUtils jwtUtils;
    @Override
    protected void doFilterInternal(
         @NonNull HttpServletRequest request,
           @NonNull HttpServletResponse response,
           @NonNull FilterChain filterChain) throws ServletException, IOException {
//        if(request.getServletPath().equals("api/v1/register")){
//            filterChain.doFilter(request, response);
//            return;
//        }
       final String header = request.getHeader(AUTHORIZATION);
//       if (!StringUtils.hasText(header) ||
//               !StringUtils.startsWithIgnoreCase(header, BEARER)){
//           filterChain.doFilter(request, response);
//           return;
//       }
       if (StringUtils.hasText(header) && StringUtils.startsWithIgnoreCase(header, BEARER)){
           final String token = header.substring(BEARER.length());
           if(jwtUtils.validateToken(token)){
               final String username = jwtUtils.extractUsername(token);

               if (username != null) {
                   UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                   UsernamePasswordAuthenticationToken authenticationToken
                           = new UsernamePasswordAuthenticationToken(
                           userDetails, null, userDetails.getAuthorities());
                   authenticationToken.setDetails(
                           new WebAuthenticationDetailsSource()
                                   .buildDetails(request)
                   );
                   SecurityContextHolder.getContext().setAuthentication(authenticationToken);
               }else{
                       response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                       new ObjectMapper().writeValue(
                               response.getOutputStream(),
                               "Authentication failed"
                       );
                   }
               }
           }
            filterChain.doFilter(request, response);
       }
    }

