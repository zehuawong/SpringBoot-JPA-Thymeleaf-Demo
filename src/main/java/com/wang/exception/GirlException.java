package com.wang.exception;

import com.wang.enums.ResultEnum;

/**
 */
public class GirlException extends RuntimeException{    //注意：spring中，只有RuntimeException才会进行事务回滚，Exception不会进行事务回滚

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
