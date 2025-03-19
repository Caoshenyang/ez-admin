package com.ezadmin.common.result.tree;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 树形对象抽象类
 * 这里原先使用的是接口方式，但是继承方式更方便，所以这里改为继承方式
 * 两者区别在于：
 * 如果你希望每个树节点实例都有自己的 children 列表，并且希望提供一些默认的实现（如 addChild 方法），那么使用抽象类更为合适。
 * 如果你希望 TreeNode 只是一个纯粹的抽象类型，并且不包含任何实现细节，那么可以使用接口。但在这种情况下，你需要将 children 字段移到具体类中。
 * </p>
 *
 * @author 曹申阳
 * @since 2024-11-19 13:46:42
 */
@Data
public abstract class TreeNode {

    /**
     * 子节点
     */
    private List<TreeNode> children = new ArrayList<>();

    /**
     * 获取节点ID
     *
     * @return 节点ID
     */
    public abstract Long getNodeId();

    /**
     * 获取父节点ID
     *
     * @return 父节点ID
     */
    public abstract Long getParentId();

    /**
     * 添加子节点
     *
     * @param child 子节点
     */
    public void addChild(TreeNode child) {
        children.add(child);
    }

}
