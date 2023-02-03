package com.cbu.backend.global;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Component
@RequiredArgsConstructor
public class RequestParamArgumentResolver implements HandlerMethodArgumentResolver {
    private final ObjectMapper mapper;
    @Override
    public boolean supportsParameter(final MethodParameter methodParameter) {
        return methodParameter.getParameterAnnotation(RequestObjectParam.class) != null;
    }

    @Override
    public Object resolveArgument(final MethodParameter methodParameter,
    final ModelAndViewContainer modelAndViewContainer,
    final NativeWebRequest nativeWebRequest,
    final WebDataBinderFactory webDataBinderFactory) throws Exception {

        final HttpServletRequest request = (HttpServletRequest) nativeWebRequest.getNativeRequest();
        final String json = qs2json(request.getQueryString());
        return mapper.readValue(json, methodParameter.getParameterType());
    }

    private String qs2json(String a) throws UnsupportedEncodingException {
        String decodeStr = URLDecoder.decode(a, StandardCharsets.UTF_8);
        decodeStr = decodeStr.replace("=", "\":\"");
        decodeStr = decodeStr.replace("&", "\",\"");

        return "{\""+decodeStr+"\"}";
    }
}