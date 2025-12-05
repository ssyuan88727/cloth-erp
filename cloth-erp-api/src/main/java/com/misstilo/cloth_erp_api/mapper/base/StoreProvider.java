package com.misstilo.cloth_erp_api.mapper.base;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import com.misstilo.cloth_erp_api.model.base.StoreModel;
import com.misstilo.cloth_erp_api.model.base.StoreQueryModel;

public class StoreProvider {
    public String insert(StoreModel model) {
        return new SQL() {
            {
                INSERT_INTO("Store");
                VALUES("Code", "#{code}");
                VALUES("Name", "#{name}");
                VALUES("StoreTypeId", "#{storeTypeId}");
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
                DELETE_FROM("Store");
                WHERE("Id = #{id}");
            }
        }.toString();
    }

    public String update(StoreModel model) {
        return new SQL() {
            {
                if (model.getId() == null) {
                    throw new RuntimeException("Update ID should not be null.");
                }
                Boolean updateFlag = false;

                UPDATE("Store");
                if (StringUtils.isNotBlank(model.getCode())) {
                    SET("Code = #{code}");
                    updateFlag = true;
                }
                if (StringUtils.isNotBlank(model.getName())) {
                    SET("Name = #{name}");
                    updateFlag = true;
                }
                if (model.getStoreTypeId() != null) {
                    SET("StoreTypeId = #{storeTypeId}");
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

    public String select(StoreQueryModel model) {
        return new SQL() {
            {
                SELECT("S.*, ST.Name AS StoreTypeName");
                FROM("Store AS S");
                INNER_JOIN("StoreType AS ST ON S.StoreTypeId = ST.Id");
                if (StringUtils.isNotBlank(model.getCode())) {
                    WHERE("Code = #{code}");
                }
                if (StringUtils.isNotBlank(model.getName())) {
                    WHERE("Name = #{name}");
                }
                if (model.getStoreTypeId() != null) {
                    WHERE ("StoreTypeId = #{storeTypeId}");
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
            }
        }.toString();
    }
}
