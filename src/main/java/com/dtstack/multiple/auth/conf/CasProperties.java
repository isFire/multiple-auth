package com.dtstack.multiple.auth.conf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="mailto:guchen@dtstack.com">古尘 At 袋鼠云</a>.
 * @description TODO
 * @date 2019/10/6 19:03
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "cas")
public class CasProperties {

    private String serverUrl;

    private String serverLoginUrl;

    private String serverLogoutUrl;

    private String frontUrl;
}
