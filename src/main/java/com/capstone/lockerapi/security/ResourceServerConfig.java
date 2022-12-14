package com.capstone.lockerapi.security;


import com.capstone.lockerapi.exceptions.CustomAccessDeniedHandler;
import com.capstone.lockerapi.exceptions.CustomAuthenticationEntryPoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    // Constructor
    public ResourceServerConfig(CustomAuthenticationEntryPoint customAuthenticationEntryPoint) {
        this.customAuthenticationEntryPoint = customAuthenticationEntryPoint;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        // Setting resource-server "resourceId" value.
        resources.resourceId("api");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // Configuring access rules for secure resources.
        http
                .csrf()
                .disable()
                .cors()
                .disable()
                // Disabling default Spring Security login page.
                .formLogin()
                .disable()
                // Setting the sessionCreationPolicy to STATELESS, meaning no session is created or used.
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // Allowing restricting access to API endpoints.
                .authorizeRequests()

                .antMatchers("/posts/**", "/teams", "/register", "/users/**", "/user/**")

                .permitAll()
                // For API documentation.
                .antMatchers("/swagger-ui/**", "/v3/api-docs/**")
                .permitAll()
                // Restricting access to any other endpoints besides those with "permitAll()"
                // And users MUST BE authenticated to access endpoints.
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(customAuthenticationEntryPoint)
                .accessDeniedHandler(new CustomAccessDeniedHandler());
    }

}
