package com.latte.core.mvp.mvpdefault;

import com.latte.core.mvp.presenter.BasePresenter;

/**
 * @author 345 QQ:1831712732
 * @name MvpFrame
 * @class name：com.latte.core.mvp.mvpdefault
 * @time 2019/9/10 21:55
 * @description P层的空实现，如果fragment或者activity中没有过多的数据需要处理，则可以直接使用这个p层
 */
public class DefaultPresenterImpl extends BasePresenter<DefaultContract.IDefaultView,DefaultModel>
        implements DefaultContract.IDefaultPresenter{

    @Override
    protected DefaultModel attachModel() {
        return null;
    }

    @Override
    public void onMvpStop() {
        super.onMvpStop();
    }
}
