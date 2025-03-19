package com.ezadmin.common.result.page;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 分页结果对象
 * </p>
 *
 * @author shenyang
 * @since 2024-10-16 16:17:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageVO<V> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(description = "总条数")
    private Long total;
    @Schema(description = "总页数")
    private Long pages;
    @Schema(description = "数据")
    private List<V> records;


    /**
     * 将 MybatisPlus 分页结果转换为 PageDTO
     *
     * @param page        MybatisPlus 分页结果
     * @param targetClass 目标类型字节码
     * @param <V>         目标数据类型
     * @param <P>         原始数据类型
     * @return 分页结果 PageDTO
     */
    public static <V, P> PageVO<V> of(Page<P> page, Class<V> targetClass) {
        List<P> records = page.getRecords();
        if (records.isEmpty()) {
            return empty(page);
        }
        // 将原始数据转换为目标数据 这里我使用了 hutool 的 BeanUtil，可以根据需要自行替换
        List<V> vs = BeanUtil.copyToList(records, targetClass);
        return new PageVO<>(page.getTotal(), page.getPages(), vs);
    }


    /**
     * 返回空的分页结果
     *
     * @param page MybatisPlus 分页结果
     * @param <V>  目标数据类型
     * @param <P>  原始数据类型
     * @return 分页结果 PageDTO
     */
    public static <V, P> PageVO<V> empty(Page<P> page) {
        return new PageVO<>(page.getPages(), page.getPages(), Collections.emptyList());
    }

}
