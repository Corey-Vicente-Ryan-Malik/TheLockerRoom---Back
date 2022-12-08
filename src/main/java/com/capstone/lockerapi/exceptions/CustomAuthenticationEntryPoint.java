package com.capstone.lockerapi.exceptions;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final HttpMessageConverter<String> messageConverter;
    private final ObjectMapper mapper;

    public CustomAuthenticationEntryPoint(HttpMessageConverter<String> messageConverter, ObjectMapper mapper) {
        this.messageConverter = messageConverter;
        this.mapper = mapper;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        ApiError apiError = new ApiError(UNAUTHORIZED);
        apiError.setMessage(authException.getMessage());
        apiError.setDebugMessage(authException.getMessage());
        ServerHttpResponse outputMessage = new ServletServerHttpResponse(response);
        outputMessage.setStatusCode(UNAUTHORIZED);
        messageConverter.write(mapper.writeValueAsString(apiError), MediaType.APPLICATION_JSON, outputMessage);
    }
}
