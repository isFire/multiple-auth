package com.dtstack.multiple.auth.conf.handler;

import com.dtstack.multiple.auth.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author <a href="mailto:guchen@dtstack.com">古尘 At 袋鼠云</a>.
 * @description 认证用户无权访问后置处理
 * @date 2019/10/5 23:37
 */
@Slf4j
public class CommonAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (log.isErrorEnabled()) {
            log.error("AccessDenied Exception Handler.--------> {}", request.getRequestURI());
        }
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.getWriter().write(Objects.requireNonNull(JsonUtils.toJsonString("用户无权限访问该资源,请联系管理员授权!!!")));
        response.flushBuffer();
    }
}
