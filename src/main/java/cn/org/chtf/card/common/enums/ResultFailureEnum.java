package cn.org.chtf.card.common.enums;

import lombok.Getter;

@Getter
public enum ResultFailureEnum {
    /**
     * 返回错误信息枚举类
     */
    LOGIN_ERROR(1, "登录失败"),
    ;

    private Integer code;

    private String msg;

    ResultFailureEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
