package com.misstilo.cloth_erp_api.mapper.base;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import com.misstilo.cloth_erp_api.model.base.ReturnReasonModel;
import com.misstilo.cloth_erp_api.model.base.ReturnReasonQueryModel;

public class ReturnReasonProvider {
    public String insert(ReturnReasonModel model) {
        return new SQL() {
            {
                INSERT_INTO("ReturnReason");
                VALUES("Reason", "#{reason}");
            }
        }.toString();
    }

    public String delete(Integer id) {
        return new SQL() {
            {
                if (id == null) {
                    throw new RuntimeException("Delete ID should not be null.");
                }
                DELETE_FROM("ReturnReason");
                WHERE("Id = #{id}");
            }
        }.toString();
    }

    public String update(ReturnReasonModel model) {
        return new SQL() {
            {
                if (model.getId() == null) {
                    throw new RuntimeException("Update ID should not be null.");
                }
                Boolean updateFlag = false;

                UPDATE("ReturnReason");
                if (StringUtils.isNotBlank(model.getReason())) {
                    SET("Reason = #{reason}");
                    updateFlag = true;
                }
                if (!updateFlag) {
                    throw new RuntimeException("請至少修改一個欄位");
                }
                WHERE("Id = #{id}");
            }
        }.toString();
    }

    public String select(ReturnReasonQueryModel model) {
        return new SQL() {
            {
                SELECT("*");
                FROM("ReturnReason");
                if (StringUtils.isNotBlank(model.getReason())) {
                    WHERE("Reason LIKE #{reason} + '%'");
                }
            }
        }.toString();
    }
}
