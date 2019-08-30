package com.latte.core.mvp.presenter;

import android.os.Bundle;
import com.latte.core.mvp.view.IBaseView;


/**
 * @author 345 QQ:1831712732
 * @name MvpFrame
 * @class name：com.latte.core.mvp.presenter
 * @time 2019/8/30 17:12
 * @description P层接口 ，会被 V 的生命周期直接调用，P层生命周期与 V层同步
 */
public interface IBasePresenter<V extends IBaseView> {

    /**
     * onCreateView() 执行完后立即回调这个方法
     */
    void onMvpAttachView(V view, Bundle savedInstanceState);

    void onMvpStart();

    void onMvpResume();

    void onMvpPause();

    void onMvpStop();

    void onMvpDetachView(boolean retainInstance);

    void onMvpDestroy();

    void onMvpSaveInstanceState(Bundle savedInstanceState);
}
