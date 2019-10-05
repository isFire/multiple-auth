package com.dtstack.multiple.auth.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Objects;

/**
` * @author <a href="mailto:guchen@dtstack.com">古尘 At 袋鼠云</a>.
 * @description TODO
 * @date 2019/10/5 22:50
 */
public class SecurityUtils {

    public static UserDetails getUser() {
        UserDetails user = null;
        if (Objects.nonNull(SecurityContextHolder.getContext().getAuthentication().getPrincipal())) {
            user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        return user;
    }
}
