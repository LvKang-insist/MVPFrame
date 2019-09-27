package com.car.customone;

import android.view.View;

import com.hjq.toast.ToastUtils;
import com.latte.core.delegate.BottomItemDelegate;
import com.latte.core.mvp.factory.CreatePresenter;
import com.latte.core.mvp.mvpdefault.DefaultContract;
import com.latte.core.mvp.mvpdefault.DefaultPresenterImpl;
import com.latte.core.mvp.presenter.IBasePresenter;
import com.latte.core.mvp.view.BaseMvpFragment;
import com.latte.core.mvp.view.IBaseView;

/**
 * @author 345 QQ:1831712732
 * @name MvpFrame
 * @class name：com.car.customone
 * @time 2019/9/26 21:58
 * @description
 */
@CreatePresenter(DefaultPresenterImpl.class)
public class CustomOneDelegate extends BottomItemDelegate<DefaultPresenterImpl> implements DefaultContract.IDefaultView  {
    @Override
    public Object setLayout() {
        return R.layout.custom_one_delegate;
    }

    @Override
    public void BindView(View view) {
       getPresenter().request(this,"","");
    }

    @Override
    public void onResult(boolean flag, String result) {
        if (flag){
            ToastUtils.show(result);
        }
    }

}
