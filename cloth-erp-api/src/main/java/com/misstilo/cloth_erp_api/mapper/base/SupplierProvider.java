package com.misstilo.cloth_erp_api.mapper.base;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import com.misstilo.cloth_erp_api.model.base.SupplierModel;
import com.misstilo.cloth_erp_api.model.base.SupplierQueryModel;

public class SupplierProvider {
    public String insert(SupplierModel model) {
        return new SQL() {
            {
                INSERT_INTO("Supplier");
                VALUES("Code", "#{code}");
                VALUES("Name", "#{name}");
                VALUES("ContactName", "#{contactName}");
                VALUES("ContactPhone", "#{contactPhone}");
                VALUES("Address", "#{address}");
                VALUES("IsActive", "#{isActive}");
            }
        }.toString();
    }

    public String delete(Integer id) {
        return new SQL() {
            {
                if (id == null) {
                    throw new RuntimeException("Delete ID should not be null.");
                }
                DELETE_FROM("Supplier");
                WHERE("Id = #{id}");
            }
        }.toString();
    }

    public String update(SupplierModel model) {
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
                if (StringUtils.isNotBlank(model.getContactName())) {
                    SET("ContactName = #{contactName}");
                    updateFlag = true;
                }
                if (StringUtils.isNotBlank(model.getContactPhone())) {
                    SET("ContactPhone = #{contactPhone}");
                    updateFlag = true;
                }
                if (StringUtils.isNotBlank(model.getAddress())) {
                    SET("Address = #{address}");
                    updateFlag = true;
                }
                if (model.getIsActive() != null) {
                    SET("IsActive = #{isActive}");
                    updateFlag = true;
                }
                if (!updateFlag) {
                    throw new RuntimeException("請至少修改一個欄位");
                }
                WHERE("Id = #{id}");
            }
        }.toString();
    }

    public String select(SupplierQueryModel model) {
        return new SQL() {
            {
                SELECT("*");
                FROM("Supplier");
                if (StringUtils.isNoneBlank(model.getCode())) {
                    WHERE("Code LIKE #{code} + '%'");
                }
                if (StringUtils.isNotBlank(model.getName())) {
                    WHERE("Name LIKE '%' + #{name} + '%'");
                }
                if (StringUtils.isNotBlank(model.getContactName())) {
                    WHERE("ContactName LIKE '%' #{contactName} + '%'");
                }
                if (StringUtils.isNotBlank(model.getContactPhone())) {
                    WHERE("ContactPhone LIKE #{contactPhone} + '%'");
                }
                if (StringUtils.isNotBlank(model.getAddress())) {
                    WHERE("Address LIKE '%' + #{#address} + '%'");
                }
                if (model.getIsActive() != null) {
                    WHERE("IsActive = #{isActive}");
                }
                if (StringUtils.isNotBlank(model.getCreateAtS())) {
                    WHERE("CreateAt >= #{createAtS}");
                }
                if (StringUtils.isNotBlank(model.getCreateAtE())) {
                    WHERE("CreateAt <= #{createAtE}");
                }
                if (StringUtils.isNotBlank(model.getUpdateAtS())) {
                    WHERE("UpdateAt >= #{updateAtS}");
                }
                if (StringUtils.isNotBlank(model.getUpdateAtE())) {
                    WHERE("UpdateAt <= #{updateAtE}");
                }
                ORDER_BY("Id");
            }
        }.toString();
    }
}
