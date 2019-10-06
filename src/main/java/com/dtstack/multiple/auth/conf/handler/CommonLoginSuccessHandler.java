package com.dtstack.multiple.auth.conf.handler;

import com.dtstack.multiple.auth.entity.UserVO;
import com.dtstack.multiple.auth.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * @author <a href="mailto:guchen@dtstack.com">古尘 At 袋鼠云</a>.
 * @description 登录成功后置处理器
 * @date 2019/10/5 23:01
 */
@Slf4j
public class CommonLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if (log.isInfoEnabled()) {
            log.info("用户登录成功 --------> {}", authentication);
        }
        // TODO 登录成功日志
        UserVO userVO = new UserVO();
        userVO.setStatus("SUCCESS");
        userVO.setMessage("登录成功");
        userVO.setPrincipal(authentication.getPrincipal());
        response.setStatus(HttpStatus.OK.value());
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType("application/json");
        response.getWriter().write(Objects.requireNonNull(JsonUtils.toJsonString(userVO)));
        response.flushBuffer();
    }
}
