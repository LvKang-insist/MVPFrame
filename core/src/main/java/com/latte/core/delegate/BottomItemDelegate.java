package com.latte.core.delegate;

import android.util.Log;
import android.widget.Toast;

import com.latte.core.mvp.factory.CreatePresenter;
import com.latte.core.mvp.presenter.IBasePresenter;
import com.latte.core.mvp.view.BaseMvpFragment;

import static android.content.ContentValues.TAG;

/**
 * @author 345 QQ:1831712732
 * @name MvpFrame
 * @class name：com.latte.core.delegate
 * @time 2019/9/25 21:44
 * @description 所有的 tabDelegate 都必须继承自这个类
 */
public abstract class BottomItemDelegate<P extends IBasePresenter> extends BaseMvpFragment {

    // 再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;
    private long TOUCH_TIME = 0;

    @Override
    public boolean onBackPressedSupport() {
        if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
            _mActivity.finish();
        } else {
            TOUCH_TIME = System.currentTimeMillis();
            Toast.makeText(_mActivity, "双击退出", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    public P getPresenter() {
       return (P) super.getPresenter();
    }
}
