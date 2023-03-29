package com.Login.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.Login.Service.Implementation.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter  {

	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	
//	@Autowired
//	private JwtTokenHelper jwtTokenHelper;
//	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		final String requestTokenHeader =request.getHeader("Authorization");
		
		System.out.println(requestTokenHeader);
		String userName=null;
		String jwtToken=null;
		
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer"))
		{
			//yes
			
			jwtToken=requestTokenHeader.substring(7);
			System.out.println(jwtToken);
			
			try {
			userName=this.jwtUtils.extractUsername(jwtToken);
			
		   System.out.println(userName+"Sahi hai");
			
			}
			catch(ExpiredJwtException e) {
				
				e.printStackTrace();
				System.out.println("jwt token has expired");
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("error");
			}
		}
			
		else
		{
			System.out.println("Invalid token,not start with Bearer string");
		}
		
		
		//Validate
		if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			System.out.println(userName);
			final UserDetails userDetails=this.userDetailsService.loadUserByUsername(userName);
			
			if(this.jwtUtils.validateToken(jwtToken, userDetails))
			{
				//token is Valid
				UsernamePasswordAuthenticationToken userNamePasswordAuthentication=new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
				
				 userNamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				
				SecurityContextHolder.getContext().setAuthentication(userNamePasswordAuthentication);
			}
		}
		else
		{
			System.out.println("Token is Not Valid");
		}
		
		
		filterChain.doFilter(request, response);
	}

}
