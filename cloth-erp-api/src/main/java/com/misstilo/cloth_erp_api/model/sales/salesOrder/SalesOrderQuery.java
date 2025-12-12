package com.misstilo.cloth_erp_api.model.sales.salesOrder;

import java.util.List;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesOrderQuery {
        @Size(max = 20, message = "訂單編號不可超過20個字")
        private String code;
        private String dateS;
        private String dateE;
        private List<Integer> memberId;
        private List<Integer> storeId;
        private List<Integer> salesPlatformId;
        private List<Integer> status;
        private List<Integer> paymentMethodId;
        @Size(max = 255, message = "備註不可超過255個字")
        private String remark;
        private String createAtS;
        private String createAtE;
        private String updateAtS;
        private String updateAtE;
}
