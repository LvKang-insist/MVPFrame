package com.latte.core.mvp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleRegistry;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import com.latte.core.mvp.base.BaseFragment;
import com.latte.core.mvp.factory.PresenterFactoryImpl;
import com.latte.core.latte.Latte;
import com.latte.core.mvp.presenter.IBasePresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author 345 QQ:1831712732
 * @name MvpFrame
 * @class name：com.latte.core.mvp.view
 * @time 2019/8/30 17:12
 * @description 抽象类， Fragment 必须继承此类，该类会调用 P 层的生命周期方法
 */
public abstract class BaseMvpFragment<P extends IBasePresenter> extends BaseFragment
        implements IBaseView, BaseMvpActivity.OnBackPressListener  {

    private P mPresenter;

    public abstract Object setLayout();

    public abstract void BindView(View view);

    private Unbinder unbinder = null;

    private View rootView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            if (setLayout() instanceof Integer) {
                rootView = inflater.inflate((Integer) setLayout(), container, false);
            } else if (setLayout() instanceof View) {
                rootView = (View) setLayout();
            } else {
                throw new NullPointerException("setLayout() must be int or View Error!");
            }
        }
        mPresenter = (P) PresenterFactoryImpl.createPresenterFactory(getClass());
        if (mPresenter == null) {
            throw new NullPointerException("Presenter is null ! Do you return null in createPresenter()");
        }
        mPresenter.onMvpAttachView(this, savedInstanceState);
        Latte.getBaseMvpActivity().setOnBackPressListener(this);

        //绑定 ButterKnife
        unbinder = ButterKnife.bind(this,rootView);
        BindView(rootView);
        //将 Lifecycle 对象和LifecycleObserver 对象进行绑定
        getLifecycle().addObserver(mPresenter);
        return rootView;
    }

    public P getPresenter(){
        return mPresenter;
    }

    @Override
    public void onSaveInstanceState(@Nullable Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mPresenter != null) {
            mPresenter.onMvpSaveInstanceState(outState);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null){
            unbinder.unbind();
            unbinder = null;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder = null;
        rootView = null;
    }

    /**
     *  如果需要 拦截返回事件，则重写该方法 return true 即可
     */
    @Override
    public boolean setBackPress() {
        return false;
    }

    /**
     * fragment基本跳转
     * A->B
     */
    public void fragmentStart(@IdRes int id) {
        Navigation.findNavController(rootView).navigate(id);
    }
    /**
     * fragment 携带数据跳转-Bundle
     * A->B
     */
    public void fragmentStart(@IdRes int id, @Nullable Bundle bundle) {
        Navigation.findNavController(rootView).navigate(id, bundle);
    }

    /**
     * fragment 携带数据新写法，Navigation 标准写法
     * 需要在 nav_host中添加相应的argument，自动生成 以下类
     * 传递端 ClassName+Directions ，接收端ClassName+Args
     * <p>
     * Demo: (传递端)RegisterDelegateDirections.actionRegisterDelegateToCreateUserDelegate(phone)
     * (接收端)CreateUserDelegateArgs.fromBundle(getArguments()).getPhone()
     *
     */
    public void fragmentStart(@NonNull NavDirections directions) {
        Navigation.findNavController(rootView).navigate(directions);
    }
    /**
     * 退栈方法
     */
    public void fragmentUp() {
        Navigation.findNavController(rootView).navigateUp();
    }

    /**
     * 跳转方法，多级跳转
     * A->B->C,C->A,避免Navigation 跳转后重新执行生命周期方法
     * @return 如果退栈一次就返回true
     */
    public boolean fragmentStartToA(@IdRes int id) {
        return Navigation.findNavController(rootView).popBackStack(id, false);
    }
}
