package com.dtstack.multiple.auth.entity;

import lombok.Data;

/**
 * @author <a href="mailto:guchen@dtstack.com">古尘 At 袋鼠云</a>.
 * @description TODO
 * @date 2019/10/6 18:34
 */
@Data
public class UserVO {

    private String status;

    private String message;

    private Object principal;


}
