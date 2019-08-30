package com.latte.core.mvp.presenter;

import android.os.Bundle;
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
public abstract class BasePresenter<V extends IBaseView, M extends BaseModel> implements IBasePresenter<V> {
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
    public void onMvpStart() {

    }

    @Override
    public void onMvpResume() {

    }

    @Override
    public void onMvpPause() {

    }

    @Override
    public void onMvpStop() {

    }

    @Override
    public void onMvpSaveInstanceState(Bundle savedInstanceState) {

    }

    private void death(boolean retainInstance) {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }


    @Override
    public void onMvpDetachView(boolean retainInstance) {
        death(retainInstance);
    }

    @Override
    public void onMvpDestroy() {

    }
}
