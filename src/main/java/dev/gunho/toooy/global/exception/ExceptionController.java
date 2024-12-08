package dev.gunho.toooy.global.exception;

import dev.gunho.toooy.global.dto.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(IllegalArgumentException.class)
    public final ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException ex) {
        log.warn("잘못된 요청 감지 : {} ", ex.getMessage());
        return ApiResponse.BAD_REQUEST(ex.getMessage());
    }
}
