package com.abdalhalem.blog;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

public class CustomMappingHandler extends RequestMappingHandlerMapping {
    private static final Logger logger = LoggerFactory.getLogger(CustomMappingHandler.class);

    @Override
    @Nullable
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        String packageName = handlerType.getPackageName();

        String prefix = "";
        if (packageName.startsWith("com.abdalhalem.blog.api")) {
            prefix = "/api";
            // logger.info("api controller {}", getMethodMapping(method));
        } else if (packageName.startsWith("com.abdalhalem.blog.dashboard")) {
            prefix = "/dashboard";
            // logger.info("dashboard controller {}", getMethodMapping(method));
        } else if (packageName.startsWith("com.abdalhalem.blog.web")) {
            prefix = "/";
            // logger.info("web controller {}", getMethodMapping(method));
        }

        RequestMappingInfo mappingInfo = super.getMappingForMethod(method, handlerType);

        if (mappingInfo != null) {
            mappingInfo = RequestMappingInfo.paths(prefix).build().combine(mappingInfo);
            logger.info("route : {}", mappingInfo);
            return mappingInfo;
        }

        return null;
    }

    private String getMethodMapping(Method method) {
        return method.getDeclaringClass().getSimpleName() + "#" + method.getName();
    }
}