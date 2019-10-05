package com.dtstack.multiple.auth.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Objects;

/**
 * @author <a href="mailto:guchen@dtstack.com">古尘 At 袋鼠云</a>.
 * @description 加密工具
 * @date 2019/10/6 00:09
 */
@Slf4j
public class PasswordUtils implements PasswordEncoder {

    public PasswordUtils() {
        if (log.isInfoEnabled()) {
            log.info("use default md5 passwordEncoder ==> {}", PasswordUtils.class);
        }
    }

    @Override
    public String encode(CharSequence rawPassword) {
        if (Objects.isNull(rawPassword)) {
            return null;
        } else {
            return SecretUtils.md5(rawPassword.toString());
        }
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (Objects.isNull(rawPassword) || Objects.isNull(encodedPassword)) {
            return false;
        }
        return SecretUtils.md5(rawPassword.toString()).equals(encodedPassword);
    }
}
