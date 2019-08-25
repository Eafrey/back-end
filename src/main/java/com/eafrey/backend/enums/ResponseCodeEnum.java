package com.eafrey.backend.enums;

public enum ResponseCodeEnum {
    SUCCESS("0", "SUCCESS");

    private String code;
    private String message;

    ResponseCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
