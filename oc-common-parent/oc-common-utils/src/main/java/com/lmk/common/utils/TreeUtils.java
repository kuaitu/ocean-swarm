package com.lmk.common.utils;

import com.lmk.common.rdbms.vo.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeUtils {
    public static <T extends TreeNode<T>> List<T> listToTree(List<T> nodeList) {
        Map<Integer, T> nodeMap = new HashMap<>();
        for (T node : nodeList) {
            nodeMap.put(node.getId(), node);
        }

        // 遍历树list，取出所有父节点不为-1的节点
        for (T node : nodeList) {
            if (node.getPid() != null && node.getPid() != -1 && nodeMap.get(node.getPid()) != null) {
                nodeMap.get(node.getPid()).getChildren().add(node);
            }
        }

        // 遍历树list，取出所有父节点为-1的节点
        List<T> returnNodeList = new ArrayList<>();
        for (T node : nodeList) {
            if (node.getPid() == null || node.getPid() == -1) {
                returnNodeList.add(node);
            }
        }
        return returnNodeList;
    }
}
