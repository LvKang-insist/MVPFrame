package com.car.customone;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;
import com.hjq.toast.ToastUtils;
import com.latte.core.delegate.BottomItemDelegate;
import com.latte.core.delegate.base.BaseDelegate;
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
 * @time 2019/9/26 21:58
 * @description
 */
@CreatePresenter(DefaultPresenterImpl.class)
public class CustomOneDelegate extends BottomItemDelegate<DefaultPresenterImpl> implements DefaultContract.IDefaultView {

    private Class<?> aClass;

    @OnClick(R2.id.btn)
    void onBtn() {

        try {
            Class<?> aClass = Class.forName("com.car.customone.SelectDelegate");

            if (aClass != null) {
                getParentDelegate().getSupportDelegate().start((BaseMvpFragment) aClass.newInstance());

            } else {
                ToastUtils.show("空");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }


    }

    @Override
    public Object setLayout() {
        return R.layout.custom_one_delegate;
    }

    @Override
    public void BindView(View view) {
        getPresenter().request(this, "", "");
    }

    @Override
    public void onResult(boolean flag, String result) {
        if (flag) {
           /* getParentDelegate()
                    .getSupportDelegate()
                    .extraTransaction()
                    .setCustomAnimations(R.anim.a1, R.anim.a2,
                            R.anim.a, R.anim.b)
                    .start(SelectDelegate.newInstance());*/
        }
    }


}
