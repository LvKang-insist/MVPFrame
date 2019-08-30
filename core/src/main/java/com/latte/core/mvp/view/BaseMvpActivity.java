package com.latte.core.mvp.view;

import android.os.Bundle;
import android.view.KeyEvent;

import androidx.annotation.Nullable;

import com.latte.core.mvp.base.BaseActivity;
import com.latte.core.mvp.factory.PresenterFactoryImpl;
import com.latte.core.latte.Latte;
import com.latte.core.mvp.presenter.IBasePresenter;

/**
 * @author 345 QQ:1831712732
 * @name MvpFrame
 * @class name：com.latte.core.mvp.view
 * @time 2019/8/30 17:12
 * @description 抽象类， Activity 必须继承此类，该类会调用 P 层的生命周期方法
 */
public abstract class BaseMvpActivity<P extends IBasePresenter> extends BaseActivity implements IBaseView {

    public P mPresenter;
    public abstract int setLayout();
    public abstract void BindView();
    public OnBackPressListener onBackPress;

    public interface OnBackPressListener{
        boolean setBackPress();
    }

    public void setOnBackPressListener(OnBackPressListener onBackPress) {
        this.onBackPress = onBackPress;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        mPresenter = (P) PresenterFactoryImpl.createPresenterFactory(getClass());
        if (mPresenter == null){
            throw new NullPointerException("Presenter is null ! Do you return null in createPresenter()?");
        }
        mPresenter.onMvpAttachView(this,savedInstanceState);
        Latte.init(this)
                .withBaseMvpActivity(this)
                .configure();
        BindView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mPresenter != null){
            mPresenter.onMvpStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter != null){
            mPresenter.onMvpResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mPresenter != null){
            mPresenter.onMvpPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mPresenter != null){
            mPresenter.onMvpStop();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mPresenter != null){
            mPresenter.onMvpSaveInstanceState(outState);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null){
            mPresenter.onMvpDetachView(false);
            mPresenter.onMvpDestroy();
        }
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (onBackPress!=null && onBackPress.setBackPress()){
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }
//    /**
//     * 重写 这个方法，目的是将 back 事件委托出去。
//     * 若栈中有两个以上Fragment，点击back 就会返回到上一个 fragment
//     */
    /*@Override
    public boolean onSupportNavigateUp() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.nav_fragment);
        return NavHostFragment.findNavController(fragment).navigateUp();
    }*/
}
