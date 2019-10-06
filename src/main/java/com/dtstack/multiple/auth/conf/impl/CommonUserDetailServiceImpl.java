package com.dtstack.multiple.auth.conf.impl;

import com.dtstack.multiple.auth.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:guchen@dtstack.com">古尘 At 袋鼠云</a>.
 * @description TODO
 * @date 2019/10/5 22:49
 */
public class CommonUserDetailServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<String> list = new ArrayList<>();
        list.add("commonLogin");
        list.add("getUserInfo");
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setId(1000L);
        user.setPassword("e99a18c428cb38d5f260853678922e03");
        user.setMenus(list);
        return user;
    }

}
