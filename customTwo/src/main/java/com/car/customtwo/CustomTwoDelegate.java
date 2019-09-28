package com.car.customtwo;

import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.hjq.toast.ToastUtils;
import com.latte.core.delegate.BottomItemDelegate;
import com.latte.core.mvp.factory.CreatePresenter;
import com.latte.core.mvp.mvpdefault.DefaultPresenterImpl;

import butterknife.OnClick;

/**
 * @author 345 QQ:1831712732
 * @name MvpFrame
 * @class name：com.car.customtwo
 * @time 2019/9/26 22:02
 * @description
 */

@CreatePresenter(DefaultPresenterImpl.class)
public class CustomTwoDelegate extends BottomItemDelegate {

    @OnClick(R2.id.two_btn)
    void onBtnClick(){
        ToastUtils.show("跳");
        ARouter.getInstance().build("/one/selectDelegate").navigation();
    }

    @Override
    public Object setLayout() {
        return R.layout.custom_two_delegate;
    }

    @Override
    public void BindView(View view) {
    }


}
