package com.dtstack.multiple.auth.controller;

import com.dtstack.multiple.auth.consts.Api;
import com.dtstack.multiple.auth.entity.UserEntity;
import com.dtstack.multiple.auth.entity.UserParam;
import com.dtstack.multiple.auth.util.SecretUtils;
import com.dtstack.multiple.auth.util.SecurityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
 * @author <a href="mailto:guchen@dtstack.com">古尘 At 袋鼠云</a>.
 * @description TODO
 * @date 2019/10/5 23:00
 */
@RestController
@RequestMapping(value = Api.API_PREFIX)
public class AuthController {

    @PostMapping(value = "/common-login")
    public Boolean commonLogin(@RequestParam String username, @RequestParam String password) {
        return Boolean.TRUE;
    }

    @GetMapping(value = "/getUserInfo")
    public UserDetails getUserInfo() {
        return SecurityUtils.getUser();
    }
}
