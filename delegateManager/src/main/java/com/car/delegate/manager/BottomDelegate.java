package com.car.delegate.manager;


import android.graphics.Color;

import com.car.customfour.CustomFourDelegate;
import com.car.customone.CustomOneDelegate;
import com.car.customthree.CustomThreeDelegate;
import com.car.customtwo.CustomTwoDelegate;
import com.latte.core.delegate.BottomItemDelegate;
import com.latte.core.delegate.BottomTabBean;
import com.latte.core.delegate.ItemBuilder;
import com.latte.core.delegate.TabItemDelegate;
import com.latte.core.mvp.factory.CreatePresenter;
import com.latte.core.mvp.mvpdefault.DefaultContract;
import com.latte.core.mvp.mvpdefault.DefaultPresenterImpl;

import java.util.LinkedHashMap;

/**
 * @author 345 QQ:1831712732
 * @name MvpFrame
 * @class name：com.latte.core.delegate
 * @time 2019/9/25 21:52
 * @description
 */
@CreatePresenter(DefaultPresenterImpl.class)
public class BottomDelegate extends TabItemDelegate implements DefaultContract.IDefaultView {

    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {
        builder.addItem(new BottomTabBean(R.drawable.one,"消息"),new CustomOneDelegate());
        builder.addItem(new BottomTabBean(R.drawable.two,"通讯录"),new CustomTwoDelegate());
        builder.addItem(new BottomTabBean(R.drawable.three,"朋友圈"),new CustomThreeDelegate());
        builder.addItem(new BottomTabBean(R.drawable.four,"我的"),new CustomFourDelegate());
        return builder.build();
    }

    @Override
    public int startDelegate() {
        return 0;
    }

    @Override
    public int selectColor() {
        return Color.parseColor("#03FF00");
    }
}
