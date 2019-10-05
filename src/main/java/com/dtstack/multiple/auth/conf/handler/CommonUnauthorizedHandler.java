package com.dtstack.multiple.auth.conf.handler;

import com.dtstack.multiple.auth.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author <a href="mailto:guchen@dtstack.com">古尘 At 袋鼠云</a>.
 * @description 未认证用户无权访问后置处理
 * @date 2019/10/5 23:52
 */
@Slf4j
public class CommonUnauthorizedHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        if (log.isErrorEnabled()) {
            log.error("Authentication Exception Handler. -------->{}", request.getRequestURI());
        }
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getWriter().write(Objects.requireNonNull(JsonUtils.toJsonString("当前用户未认证,请认证后重试!!!")));
        response.flushBuffer();
    }
}
