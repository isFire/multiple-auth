package com.dtstack.multiple.auth.controller;

import com.dtstack.multiple.auth.consts.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:guchen@dtstack.com">古尘 At 袋鼠云</a>.
 * @description TODO
 * @date 2019/10/5 23:00
 */
@RestController
@RequestMapping(value = Api.API_PREFIX)
public class AuthController {

    @PostMapping(value = "/common-login")
    public String commonLogin() {
        return "";
    }

}
