package com.ezadmin.common.result.page;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import io.micrometer.common.lang.Nullable;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
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
     * 模糊查询关键词
     */
    private String keyword;

//    /**
//     * 精确筛选条件（字段 -> 值）
//     */
//    private final Map<SFunction<T, ?>, Object> exactFilters = new HashMap<>();
//
//    /**
//     * 范围筛选条件（字段 -> 范围）
//     */
//    private final Map<SFunction<T, ? extends Comparable<?>>, Range<?>> rangeFilters = new HashMap<>();

    /**
     * 指定参与模糊查询的字段（由子类实现）
     */
    public abstract List<SFunction<T, String>> getKeywordSearchFields();

    /**
     * 构建MyBatis-Plus查询条件
     *
     * @return LambdaQueryWrapper
     */
    public LambdaQueryWrapper<T> buildWrapper() {
        LambdaQueryWrapper<T> wrapper = new LambdaQueryWrapper<>();

        // 1. 模糊查询
        buildKeywordCondition(wrapper);

//        // 2. 精确筛选
//        exactFilters.forEach(wrapper::eq);
//
//        // 3. 范围筛选
//        rangeFilters.forEach((field, range) -> {
//            if (range.getMin() != null) {
//                wrapper.ge(field, range.getMin());
//            }
//            if (range.getMax() != null) {
//                wrapper.le(field, range.getMax());
//            }
//        });

        return wrapper;
    }

    /**
     * 构建模糊查询条件
     *
     * @param wrapper LambdaQueryWrapper
     */
    private void buildKeywordCondition(LambdaQueryWrapper<T> wrapper) {
        if (StringUtils.isBlank(keyword)) return;

        List<SFunction<T, String>> fields = getKeywordSearchFields();
        if (fields.isEmpty()) return;

        wrapper.and(w -> {
            for (SFunction<T, String> field : fields) {
                w.or().like(field, keyword);
            }
        });
    }

    /**
     * 范围查询值封装
     */
    @Data
    public static class Range<V extends Comparable<V>> {
        private V min;
        private V max;

        public static <V extends Comparable<V>> Range<V> of(V min, V max) {
            Range<V> range = new Range<>();
            range.setMin(min);
            range.setMax(max);
            return range;
        }
    }
}
