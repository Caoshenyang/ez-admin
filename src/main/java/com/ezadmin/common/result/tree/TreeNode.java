package com.ezadmin.common.result.tree;


/**
 * <p>
 * 树形对象抽象接口
 * </p>
 *
 * @author 曹申阳
 * @since 2024-11-19 13:46:42
 */
public interface TreeNode {
    /**
     * 获取节点ID
     *
     * @return 节点ID
     */
    Long getNodeId();

    /**
     * 获取父节点ID
     *
     * @return 父节点ID
     */
    Long getParentId();

    /**
     * 添加子节点
     *
     * @param child 子节点
     */
    void addChild(TreeNode child);

}
