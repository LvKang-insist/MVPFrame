package com.car.customone;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import com.hjq.toast.ToastUtils;
import com.latte.core.delegate.BottomItemDelegate;
import com.latte.core.mvp.factory.CreatePresenter;
import com.latte.core.mvp.mvpdefault.DefaultContract;
import com.latte.core.mvp.mvpdefault.DefaultPresenterImpl;
import com.latte.core.ui.dialog.BaseFragDialog;
import com.latte.core.ui.dialog.DateDialog;
import com.latte.core.ui.dialog.ToastDialog;

import butterknife.OnClick;

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

    @OnClick(R2.id.t1)
    void onBtn() {
       /* BaseFragDialog.Builder()
                .setContentView(R.layout.dialog)
                .setAnimation(R.style.BottomAnimStyle)
                .setCancelable(false)
                .build()
                .setText(R.id.tv_dialog_title,"我是标题")
                .setText(R.id.tv_dialog_message,"我是内容")
                .setListener(R.id.tv_dialog_cancel, (dialog, view) -> {
                    ToastUtils.show("取消");
                    dialog.dismiss();
                })
                .setListener(R.id.tv_dialog_confirm, (dialog, view) -> {
                    ToastUtils.show("成功");
                    dialog.dismiss();
                })
                .show(getChildFragmentManager(),"id");*/

        /*DateDialog.DateBuilder()
                .setContentView(R.layout.dialog)
                .setAnimation(R.style.BottomAnimStyle)
                .setCancelable(false)
                .setGravity(Gravity.CENTER)
                .build()
                .show(getChildFragmentManager(),"");*/

        ToastDialog.ToastBuilder()
                .setContentView(R.layout.dialog_toast)
                .setCancelable(false)
                .build()
                .setType(ToastDialog.Type.WARN)
                .setMessage("警告")
                .show(getChildFragmentManager(),"toast");
    }

    @Override
    public Object setLayout() {
        return R.layout.custom_one_delegate;
    }

    @Override
    public void BindView(View view) {
        getPresenter().request(this, "LvKang-insist/ImitateQQMusic/blob/master/core/src/main/java/com/admin/core/net/RestCreator.java", null);
    }

    @Override
    public void onResult(boolean flag, String result) {
        if (flag) {
            Log.e("--------" , "onResult: "+result );
        }
    }
}
