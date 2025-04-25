package com.ezadmin.model.query;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.ezadmin.common.result.page.BaseQuery;
import com.ezadmin.modules.system.entity.Dept;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 类名: DeptQuery
 * 功能描述: 部门查询
 *
 * @author shenyang
 * @since 2025/4/25 16:37
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DeptQuery extends BaseQuery<Dept> implements Serializable {

    @Schema(description = "部门名称")
    private String deptName;


    @Override
    public List<SFunction<Dept, String>> getKeywordSearchFields() {
        // 直接指定哪些字段参与模糊查询
        return Arrays.asList(Dept::getDeptName, Dept::getDescription);
    }
}
