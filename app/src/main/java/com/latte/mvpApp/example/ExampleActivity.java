package com.latte.mvpApp.example;
import com.car.delegate.manager.BottomDelegate;
import com.car.delegate.manager.BottomSlideDelegate;
import com.latte.core.delegate.base.BaseDelegate;

import com.latte.core.mvp.factory.CreatePresenter;
import com.latte.core.mvp.mvpdefault.DefaultContract;

import com.latte.core.mvp.mvpdefault.DefaultPresenterImpl;
import com.latte.core.mvp.view.BaseMvpActivity;

/**
 * @author 345 QQ:1831712732
 * @name MvpFrame
 * @class name：com.latte.mvpApp.example
 * @time 2019/8/30 17:12
 * @description 主Activity
 */
@CreatePresenter(DefaultPresenterImpl.class)
public class ExampleActivity extends BaseMvpActivity {

    @Override
    public BaseDelegate setRootDelegate() {
        return new BottomSlideDelegate();
    }

    @Override
    public void BindView() {

    }
}
