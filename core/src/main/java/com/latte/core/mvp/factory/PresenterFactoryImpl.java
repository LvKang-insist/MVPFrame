package com.latte.core.mvp.factory;

import android.util.Log;

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
public class PresenterFactoryImpl{

    public static <V extends IBaseView, P extends BasePresenter<V, BaseModel>> P createPresenterFactory(Class<?> viewClass) {
        CreatePresenter annotation = viewClass.getAnnotation(CreatePresenter.class);
        Class<P> pClass = null;
        if (annotation != null) {
            pClass = (Class<P>) annotation.value();
        }
        try {
            return pClass != null ? pClass.newInstance() : null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

}
