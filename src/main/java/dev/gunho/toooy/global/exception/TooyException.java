package dev.gunho.toooy.global.exception;

import dev.gunho.toooy.global.dto.ApiResponseCode;
import lombok.Getter;

@Getter
public class TooyException extends RuntimeException{
    private final int status;



    public TooyException(String message, int status) {
        super(message);
        this.status = status;
    }

    public TooyException(ApiResponseCode responseCode) {
        super(responseCode.getMessage());
        this.status = responseCode.getCode();
    }
}
