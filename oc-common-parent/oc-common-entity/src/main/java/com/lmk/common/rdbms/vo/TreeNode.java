package com.lmk.common.rdbms.vo;

import java.util.List;

public interface TreeNode<T extends TreeNode<T>> {
    Integer getId();

    Integer getPid();

    List<T> getChildren();
}
