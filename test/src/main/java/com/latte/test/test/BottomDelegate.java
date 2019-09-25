package com.latte.test.test;

import com.latte.core.delegate.BottomItemDelegate;
import com.latte.core.delegate.BottomTabBean;
import com.latte.core.delegate.ItemBuilder;
import com.latte.core.delegate.LatteDelegate;
import com.latte.core.mvp.factory.CreatePresenter;
import com.latte.core.mvp.mvpdefault.DefaultContract;
import com.latte.core.mvp.mvpdefault.DefaultPresenterImpl;
import com.latte.core.mvp.view.BaseMvpFragment;

import java.util.LinkedHashMap;

/**
 * @author 345 QQ:1831712732
 * @name MvpFrame
 * @class name：com.latte.core.delegate
 * @time 2019/9/25 21:52
 * @description
 */
@CreatePresenter(DefaultPresenterImpl.class)
public class BottomDelegate extends LatteDelegate implements DefaultContract.IDefaultView {

    @Override
    public LinkedHashMap<BottomTabBean, BaseMvpFragment> setItems(ItemBuilder builder) {
        builder.addItem(new BottomTabBean("哈哈哈","嘻嘻嘻"),new TextOne());
        return builder.build();
    }

    @Override
    public int startDelegate() {
        return 0;
    }
}
