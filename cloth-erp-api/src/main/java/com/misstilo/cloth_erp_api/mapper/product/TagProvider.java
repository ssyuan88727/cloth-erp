package com.misstilo.cloth_erp_api.mapper.product;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import com.misstilo.cloth_erp_api.model.product.TagModel;
import com.misstilo.cloth_erp_api.model.product.TagQueryModel;

public class TagProvider {
    public String insert(TagModel model) {
        return new SQL() {
            {
                INSERT_INTO("Tag");
                VALUES("Name", "#{name}");
            }
        }.toString();
    }

    public String delete(Integer id) {
        return new SQL() {
            {
                if (id == null) {
                    throw new RuntimeException("Delete ID should not be null.");
                }
                DELETE_FROM("Tag");
                WHERE("Id = #{id}");
            }
        }.toString();
    }

    public String update(TagModel model) {
        return new SQL() {
            {
                if (model.getId() == null) {
                    throw new RuntimeException("Update ID should not be null.");
                }
                Boolean updateFlag = false;

                if (StringUtils.isNotBlank(model.getName())) {
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

    public String select(TagQueryModel model) {
        return new SQL() {
            {
                SELECT("*");
                FROM("Tag");
                if (StringUtils.isNotBlank(model.getName())) {
                    WHERE("Name LIKE #{name} + '%'");
                }
            }
        }.toString();
    }
}
