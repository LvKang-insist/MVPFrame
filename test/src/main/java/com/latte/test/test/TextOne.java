package com.latte.test.test;

import android.view.View;

import com.latte.core.mvp.factory.CreatePresenter;
import com.latte.core.mvp.mvpdefault.DefaultContract;
import com.latte.core.mvp.mvpdefault.DefaultPresenterImpl;
import com.latte.core.mvp.view.BaseMvpFragment;
import com.latte.test.R;

/**
 * @author 345 QQ:1831712732
 * @name MvpFrame
 * @class name：com.latte.test.test
 * @time 2019/9/11 22:38
 * @description
 */

@CreatePresenter(DefaultPresenterImpl.class)
public class TextOne extends BaseMvpFragment implements DefaultContract.IDefaultView {

    @Override
    public Object setLayout() {
        return R.layout.text_one;
    }

    @Override
    public void BindView(View view) {

    }

}
