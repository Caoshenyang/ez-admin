package com.ezadmin.common.result.page;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 类名: BaseQuery
 * 功能描述: 查询基类
 *
 * @author shenyang
 * @since 2025/4/25 17:00
 */
@Data
public abstract class BaseQuery<T> implements Serializable {
    /**
     * 关键字查询
     */
    private String keyword;

    /**
     * 直接返回需要模糊查询的字段函数列表
     */
    public abstract List<SFunction<T, String>> getKeywordSearchFields();
}
