package com.misstilo.cloth_erp_api.model.store.storeType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreTypeUpdate {
    @NotNull(message = "Update: Id is required.")
    private Integer id;
    @NotBlank(message = "名稱不可為空")
    @Size(max = 20, message = "名稱不可超過20字")
    private String name;
}
