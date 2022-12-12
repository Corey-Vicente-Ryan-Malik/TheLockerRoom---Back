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

// This class is used to set necessary response headers and content-type before sending the response back to the client
// Implementing AuthenticationEntryPoint interface to provide better Spring Security filter chain management.
/**
 * AuthenticationEntryPoint is used to send an HTTP response that requests credentials from a client.
 */
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    /**
     * HttpMessageConverter is used for serializing Java Object to JSON data representation
     * and deserializing JSON/XML data to Java Object.
     **/
    private final HttpMessageConverter<String> messageConverter;

    /**
     * ObjectMapper provides functionality for reading and writing JSON,
     * either to and from basic POJOs (Plain Old Java Objects),
     * or to and from a general-purpose JSON Tree Model ( JsonNode ),
     * as well as related functionality for performing conversions.
     **/
    private final ObjectMapper mapper;

    // Constructor
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
