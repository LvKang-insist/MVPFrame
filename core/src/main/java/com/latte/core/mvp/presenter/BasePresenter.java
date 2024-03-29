package com.latte.core.mvp.presenter;

import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.latte.core.mvp.model.BaseModel;
import com.latte.core.mvp.view.IBaseView;

import java.lang.ref.WeakReference;

/**
 * @author 345 QQ:1831712732
 * @name MvpFrame
 * @class name：com.latte.core.mvp.presenter
 * @time 2019/8/30 17:12
 * @description P层基类 需要被继承，内部对生命周期进行代理，可直接在 P 层使用生命周期
 */
public abstract class BasePresenter<V extends IBaseView, M extends BaseModel>
        implements IBasePresenter<V>  {

    private static final String TAG = "BasePresenter";

    private WeakReference<V> viewRef;
    private WeakReference<M> modelRef;

    public V getView() {
        return isViewAttached() ? viewRef.get() : null;
    }

    public M getModel() {
        return modelRef.get();
    }

    protected abstract M attachModel();

    protected boolean isViewAttached() {
        return viewRef != null && viewRef.get() != null;
    }

    private void attache(V view, Bundle saveInstanceState) {
        viewRef = new WeakReference<>(view);
        modelRef = new WeakReference<>(attachModel());
    }

    @Override
    public void onMvpAttachView(V view, Bundle savedInstanceState) {
        attache(view, savedInstanceState);
    }

    @Override
    public void onMvpSaveInstanceState(Bundle savedInstanceState) {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onMvpCreate(){
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onMvpStart() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onMvpResume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onMvpPause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onMvpStop() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onMvpDestroy() {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }
}
