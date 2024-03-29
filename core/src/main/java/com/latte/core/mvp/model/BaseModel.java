package com.latte.core.mvp.model;

import androidx.annotation.CallSuper;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.WeakHashMap;

/**
 * @author 345 QQ:1831712732
 * @name MvpFrame
 * @class name：com.latte.core.mvp.model
 * @time 2019/8/30 17:12
 * @description 抽象 M 层 需要被继承，默认一个请求数据的方法，可重写或者重载，也可以自定义
 */
public abstract class BaseModel<T> extends ViewModel {

    public MutableLiveData<T> data;

    public BaseModel(){
        init();
    }

    public void init() {
        if (data == null) {
            data = new MutableLiveData<>();
        }
    }

    public MutableLiveData<T> getLiveData() {
        return data;
    }

    public abstract MutableLiveData<T> request(String url,  WeakHashMap param);
}
