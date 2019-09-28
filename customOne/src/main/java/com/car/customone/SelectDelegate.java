package com.car.customone;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hjq.toast.ToastUtils;
import com.latte.core.mvp.factory.CreatePresenter;
import com.latte.core.mvp.mvpdefault.DefaultContract;
import com.latte.core.mvp.mvpdefault.DefaultPresenterImpl;
import com.latte.core.mvp.view.BaseMvpFragment;

import butterknife.OnClick;
import me.yokeyword.fragmentation.ISupportFragment;

/**
 * @author 345 QQ:1831712732
 * @name MvpFrame
 * @class name：com.car.customone
 * @time 2019/9/28 20:47
 * @description
 */
@CreatePresenter(DefaultPresenterImpl.class)
@Route(path = "/one/selectDelegate")
public class SelectDelegate extends BaseMvpFragment<DefaultPresenterImpl> {

    @OnClick(R2.id.select_back)
    void onBack(){
        /*getSupportDelegate()
                .extraTransaction()
                .setCustomAnimations(R.anim.dialog_left_in, R.anim.dialog_left_out,
                        R.anim.right_in, R.anim.right_out);*/
    }

    public static ISupportFragment newInstance() {
        return new SelectDelegate();
    }

    @Override
    public Object setLayout() {
        return R.layout.select_delegate;
    }

    @Override
    public void BindView(View view) {

    }

    @Override
    public boolean onBackPressedSupport() {
        ToastUtils.show("返回");
     /*   getSupportDelegate().extraTransaction()
                .setCustomAnimations(R.anim.dialog_left_in, R.anim.dialog_left_out,
                        R.anim.right_in, R.anim.right_out);*/
        return false;
    }
}
