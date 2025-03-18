package com.ezadmin.common.result.page;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 分页查询对象
 * </p>
 *
 * @author 曹申阳
 * @since 2024-10-16 16:24:56
 */
@Data
public class PageQuery<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "当前页码", defaultValue = "1")
    private Integer pageNum = 1;
    @Schema(description = "每页显示条数", defaultValue = "10")
    private Integer pageSize = 10;
    @Schema(description = "排序对象，支持多字段排序")
    private List<OrderItem> orderItems;
    @Schema(description = "查询对象")
    private T search;


    /**
     * 将当前对象转换为 MybatisPlus 分页对象
     *
     * @param <PO> PO类型
     * @return Page<PO>
     */
    public <PO> Page<PO> toMpPage() {
        Page<PO> page = Page.of(pageNum, pageSize);
        if (orderItems != null && !orderItems.isEmpty()) {
            page.addOrder(orderItems);
        } else {
            // 如果不传默认根据创建时间倒序
            page.addOrder(OrderItem.desc("create_time"));
        }
        return page;
    }

}
