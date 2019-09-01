package com.latte.core.mvp.view;

import android.os.Bundle;
import android.util.Log;
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
 * @description 抽象类， Activity 必须继承此类
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
        //将 Lifecycle 对象和LifecycleObserver 对象进行绑定
        getLifecycle().addObserver(mPresenter);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mPresenter != null){
            mPresenter.onMvpSaveInstanceState(outState);
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
