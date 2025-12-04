package com.misstilo.cloth_erp_api.mapper.base;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import com.misstilo.cloth_erp_api.model.base.StoreTypeModel;
import com.misstilo.cloth_erp_api.model.base.StoreTypeQueryModel;

public class StoreTypeProvider {
    public String insert(StoreTypeModel model) {
        return new SQL() {
            {
                INSERT_INTO("StoreType");
                VALUES("Name", "#{name}");
            }
        }.toString();
    }

    public String delete(Integer id) {
        return new SQL() {
            {
                DELETE_FROM("StoreType");
                WHERE("Id = #{id}");
            }
        }.toString();
    }

    public String update(StoreTypeModel model) {
        return new SQL() {
            {
                if (model.getId() == null) {
                    throw new RuntimeException("Update ID should not be null.");
                }
                boolean updateFlag = false;
                UPDATE("StoreType");
                if (model.getName() != null) {
                    SET("Name = #{name}");
                    updateFlag = true;
                }
                if (!updateFlag) {
                    throw new RuntimeException("請至少修改一個欄位");
                }
                WHERE("Id = #{id}");
            }
        }.toString();
    }

    public String select(StoreTypeQueryModel model) {
        return new SQL() {
            {
                SELECT("*");
                FROM("StoreType");
                if (StringUtils.isNotBlank(model.getName())) {
                    WHERE("Name LIKE #{name} + '%'");
                }
                ORDER_BY("Id");
            }
        }.toString();
    }
}
