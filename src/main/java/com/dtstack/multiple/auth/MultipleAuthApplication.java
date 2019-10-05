package com.dtstack.multiple.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * @author <a href="mailto:guchen@dtstack.com">古尘 At 袋鼠云</a>.
 * @description TODO
 * @date 2019/10/5 22:41
 */
@EnableWebSecurity
@SpringBootApplication
public class MultipleAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultipleAuthApplication.class, args);
    }

}
