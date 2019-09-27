package com.latte.core.mvp.mvpdefault;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.latte.core.mvp.presenter.BasePresenter;
import com.latte.core.mvp.view.BaseMvpFragment;

/**
 * @author 345 QQ:1831712732
 * @name MvpFrame
 * @class name：com.latte.core.mvp.mvpdefault
 * @time 2019/9/10 21:55
 * @description P层的默认实现，如果fragment或者activity中没有过多的数据需要处理，则可以直接使用这个p层
 */
public class DefaultPresenterImpl extends BasePresenter<DefaultContract.IDefaultView, DefaultModel>
        implements DefaultContract.IDefaultPresenter {

    @Override
    protected DefaultModel attachModel() {
        return new ViewModelProvider.NewInstanceFactory().create(DefaultModel.class);
    }

    @Override
    public void request(BaseMvpFragment mvpFragment, String url, String p) {
        DefaultModel defaultModel = new ViewModelProvider.NewInstanceFactory().create(DefaultModel.class);
        defaultModel.request(url,p)
                .observe(mvpFragment, (Observer<String>) s -> {
                    getView().onResult(true,"请求成功");
                });
    }

}
