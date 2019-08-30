package com.latte.mvpApp.example;

import com.latte.core.mvp.presenter.IBasePresenter;
import com.latte.core.mvp.view.IBaseView;

/**
 * @author 345 QQ:1831712732
 * @name MvpFrame
 * @class name：com.latte.mvpApp.example
 * @time 2019/8/30 17:12
 * @description 契约类 ，V层 和 P层的接口
 */
public class ExampleContract {

    public interface IExampleView extends IBaseView{

    }

    public interface IExamplePresenter extends IBasePresenter<IExampleView>{

    }
}
