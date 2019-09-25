package com.latte.core.delegate;

import com.latte.core.mvp.view.BaseMvpFragment;

import java.util.LinkedHashMap;

/**
 * Copyright (C)
 *
 * @file: ItemBuilder
 * @author: 345
 * @Time: 2019/4/25 19:42
 * @description: 工厂类，用来构建 导航栏 和 碎片
 */
public final class ItemBuilder {

    private final LinkedHashMap<BottomTabBean, BaseMvpFragment> ITEMS = new LinkedHashMap<>();

    public static ItemBuilder builder(){
        return new ItemBuilder();
    }

    public final void addItem(BottomTabBean bean, BaseMvpFragment delegate){
        ITEMS.put(bean,delegate);
    }

    public final ItemBuilder addItem(LinkedHashMap<BottomTabBean,BaseMvpFragment> items){
        ITEMS.putAll(items);
        return this;
    }

    public final LinkedHashMap<BottomTabBean,BaseMvpFragment> build(){
        return ITEMS;
    }
}
