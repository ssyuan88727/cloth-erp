package com.misstilo.cloth_erp_api.handler;

import java.util.stream.Collectors;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.misstilo.cloth_erp_api.model.response.ResponseModel;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 處理參數驗證異常(@Valid)
     * 
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseModel<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errors = ex.getBindingResult().getAllErrors().stream()
                .map(error -> error.getDefaultMessage() + "\n")
                .collect(Collectors.joining("; "));
        return ResponseModel.error("參數驗證失敗", errors);
    }

    /**
     * 處理資料重複異常
     * 
     * @param ex
     * @return
     */
    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseModel<?> handleDuplicateKeyException(DuplicateKeyException ex) {
        return ResponseModel.error("資料已存在", "已有相同資料存在");
    }

    /**
     * 處理其他異常
     * 
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseModel<?> handleGeneralException(Exception ex) {
        return ResponseModel.error("系統發生錯誤，請稍後再試。", ex.getMessage());
    }
}