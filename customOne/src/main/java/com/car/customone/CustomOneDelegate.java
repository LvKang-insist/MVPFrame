package com.car.customone;

import android.view.View;

import com.latte.core.delegate.BottomItemDelegate;
import com.latte.core.mvp.factory.CreatePresenter;
import com.latte.core.mvp.mvpdefault.DefaultPresenterImpl;

/**
 * @author 345 QQ:1831712732
 * @name MvpFrame
 * @class name：com.car.customone
 * @time 2019/9/26 21:58
 * @description
 */
@CreatePresenter(DefaultPresenterImpl.class)
public class CustomOneDelegate extends BottomItemDelegate {
    @Override
    public Object setLayout() {
        return R.layout.custom_one_delegate;
    }

    @Override
    public void BindView(View view) {

    }
}
