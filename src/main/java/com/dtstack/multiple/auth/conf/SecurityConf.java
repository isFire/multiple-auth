package com.dtstack.multiple.auth.conf;

import com.dtstack.multiple.auth.conf.handler.*;
import com.dtstack.multiple.auth.conf.impl.CasUserDetailServiceImpl;
import com.dtstack.multiple.auth.consts.Login;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * @author <a href="mailto:guchen@dtstack.com">古尘 At 袋鼠云</a>.
 * @description TODO
 * @date 2019/10/5 22:41
 */
@Configuration
public class SecurityConf extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement()
                .enableSessionUrlRewriting(false)
                .and()
                .authorizeRequests()
                // 登录与注销请求放行
                .antMatchers(Login.CAS_LOGIN, Login.CAS_LOGOUT).permitAll()
                // 其他请求一律拦截
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl(Login.CAS_LOGIN)
                .failureHandler(loginFailureHandler())
                .successHandler(loginSuccessHandler())
                .and()
                .csrf().disable()
                .logout()
                .logoutUrl(Login.CAS_LOGOUT)
                .logoutSuccessHandler(logoutSuccessHandler())
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint())
                .accessDeniedHandler(accessDeniedHandler());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 静态资源放行
        web.ignoring().antMatchers("/static/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.parentAuthenticationManager(authenticationManager());
    }

    @Bean
    @ConditionalOnMissingBean(value = CasUserDetailServiceImpl.class)
    public AuthenticationUserDetailsService<CasAssertionAuthenticationToken> casUserDetailService() {
        return new CasUserDetailServiceImpl();
    }

    @Bean
    @ConditionalOnMissingBean(value = CommonLoginFailureHandler.class)
    public AuthenticationFailureHandler loginFailureHandler() {
        return new CommonLoginFailureHandler();
    }

    @Bean
    @ConditionalOnMissingBean(value = CommonLoginSuccessHandler.class)
    public AuthenticationSuccessHandler loginSuccessHandler() {
        return new CommonLoginSuccessHandler();
    }

    @Bean
    @ConditionalOnMissingBean(value = CommonLogoutSuccessHandler.class)
    public LogoutSuccessHandler logoutSuccessHandler() {
        return new CommonLogoutSuccessHandler();
    }

    @Bean
    @ConditionalOnMissingBean(value = CommonAccessDeniedHandler.class)
    public AccessDeniedHandler accessDeniedHandler() {
        return new CommonAccessDeniedHandler();
    }

    @Bean
    @ConditionalOnMissingBean(value = CommonUnauthorizedHandler.class)
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new CommonUnauthorizedHandler();
    }

}
