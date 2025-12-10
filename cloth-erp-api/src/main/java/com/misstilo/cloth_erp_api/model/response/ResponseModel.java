package com.misstilo.cloth_erp_api.model.response;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseModel<T> {
    @NotNull(message = "Header is required.")
    @Valid
    private ResponseHeaderModel header;
    private T body;

    public static <T> ResponseModel<T> success(T data) {
        return new ResponseModel<>(
                ResponseHeaderModel.builder().status(true).title("成功").message("").build(),
                data);
    }

    public static <T> ResponseModel<T> error(String title, String message) {
        return new ResponseModel<>(
                ResponseHeaderModel.builder().status(false).title(title).message(message).build(),
                null);
    }
}
