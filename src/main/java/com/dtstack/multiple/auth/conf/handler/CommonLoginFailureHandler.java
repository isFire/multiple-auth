package com.dtstack.multiple.auth.conf.handler;

import com.dtstack.multiple.auth.entity.UserVO;
import com.dtstack.multiple.auth.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * @author <a href="mailto:guchen@dtstack.com">古尘 At 袋鼠云</a>.
 * @description 登录失败后置处理器
 * @date 2019/10/5 23:06
 */
@Slf4j
public class CommonLoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        if (log.isWarnEnabled()) {
            log.warn("登录失败", e);
        }
        // TODO 登录失败日志
        UserVO userVO = new UserVO();
        userVO.setStatus("ERROR");
        userVO.setMessage("登录失败,用户名或密码错误");
        response.setStatus(HttpStatus.OK.value());
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType("application/json");
        response.getWriter().write(Objects.requireNonNull(JsonUtils.toJsonString(userVO)));
        response.flushBuffer();
    }
}
