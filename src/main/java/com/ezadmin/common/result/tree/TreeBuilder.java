package com.ezadmin.common.result.tree;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>
 * TreeBuilder
 * </p>
 *
 * @author shenyang
 * @since 2024-11-19 13:54:32
 */
public class TreeBuilder {

    /**
     * 将树形数据列表转换为树形结构的数据对象
     *
     * @param dataList 包含树形数据的列表
     * @param <T>      树形数据对象的类型
     * @return 树形结构的数据对象
     */
    public static <T extends TreeNode> List<T> buildTree(List<T> dataList) {
        if (dataList == null || dataList.isEmpty()) {
            return new ArrayList<>();
        }
        // 创建一个映射，用于存储每个节点的ID和对应的节点对象 k - nodeId, v - treeNode
        Map<Long, T> nodeMap = dataList.stream().collect(Collectors
                .toMap(TreeNode::getNodeId,
                        Function.identity(),
                        (existing, replacement) -> existing,  // 合并函数，当键冲突时保留原有值
                        LinkedHashMap::new // 指定使用LinkedHashMap
                ));


        // 暂存当前数据集的根节点ID
        List<Long> roots = new ArrayList<>();
        // 构建树形结构
        dataList.forEach(node -> {
            Long parentId = node.getParentId();
            // 判断是否为根节点，如果在列表无法找到对应的父节点，则其为根节点(父节点为 0 刚好也满足这个条件)，则将其添加到 roots 列表中
            if (parentId == null || !nodeMap.containsKey(parentId)) {
                roots.add(node.getNodeId());
                // 根节点 查找指定id的节点，如果不存在，则将其添加进 nodeMap,存在则不处理
                nodeMap.computeIfAbsent(node.getNodeId(), k -> node);
            } else {
                // 非根节点，将其添加到父节点的子节点列表中，查找当指定的键值存在时
                nodeMap.computeIfPresent(parentId, (key, parentNode) -> {
                    parentNode.addChild(node);
                    return parentNode;
                });
            }
        });

        // 返回根节点列表
        return nodeMap.values().stream()
                .filter(node -> roots.contains(node.getNodeId()))
                .collect(Collectors.toList());
    }
}
