package com.dtstack.multiple.auth.conf.impl;

import com.dtstack.multiple.auth.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:guchen@dtstack.com">古尘 At 袋鼠云</a>.
 * @description TODO
 * @date 2019/10/5 22:49
 */
@Slf4j
public class CasUserDetailServiceImpl implements AuthenticationUserDetailsService<CasAssertionAuthenticationToken> {

    @Override
    public UserDetails loadUserDetails(CasAssertionAuthenticationToken token) throws UsernameNotFoundException {
        String name = token.getAssertion().getPrincipal().getName();
        List<String> list = new ArrayList<>();
        list.add("casLogin");
        list.add("getUserInfo");
        UserEntity user = new UserEntity();
        user.setUsername(name);
        user.setId(2000L);
        user.setPassword("e99a18c428cb38d5f260853678922e03");
        user.setMenus(list);
        return user;
    }
}
