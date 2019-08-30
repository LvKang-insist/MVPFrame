package com.latte.core.mvp.factory;

import com.latte.core.mvp.model.BaseModel;
import com.latte.core.mvp.presenter.BasePresenter;
import com.latte.core.mvp.view.IBaseView;

/**
 * @author 345 QQ:1831712732
 * @name MvpFrame
 * @class name：com.latte.core.mvp.factory
 * @time 2019/8/30 17:12
 * @description P层的工厂，通过注解 CreatePresenter 来生成 P层的实例
 */
public class PresenterFactoryImpl<V extends IBaseView, P extends BasePresenter<V, BaseModel>> {

    private Class<P> mPresenterClass;

    private PresenterFactoryImpl(Class<P> presenterClass) {
        mPresenterClass = presenterClass;
    }

    public static  <v extends IBaseView, p extends BasePresenter<v, BaseModel>> p createPresenterFactory(Class<?> viewClass) {
        CreatePresenter annotation = viewClass.getAnnotation(CreatePresenter.class);
        Class<p> pClass = null;
        if (annotation != null) {
            pClass = (Class<p>) annotation.value();
        }
        return pClass != null ? new PresenterFactoryImpl<>(pClass).createPresenter() : null;
    }


    private P createPresenter() {

        try {
            return mPresenterClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Presenter 创建失败，请确定是否声明了 @CreatePresenter");
        }

    }


}
