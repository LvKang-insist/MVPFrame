package com.latte.mvpApp.example;

import com.latte.core.mvp.presenter.BasePresenter;

/**
 * @author 345 QQ:1831712732
 * @name MvpFrame
 * @class name：com.latte.mvpApp.example
 * @time 2019/8/30 17:12
 * @description P层
 */
public class ExamplePersenter extends BasePresenter<ExampleContract.IExampleView,ExampModel> {

    @Override
    protected ExampModel attachModel() {
        return new ExampModel();
    }
}
