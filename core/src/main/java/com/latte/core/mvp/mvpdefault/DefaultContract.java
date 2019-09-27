package com.latte.core.mvp.mvpdefault;

import com.latte.core.mvp.presenter.IBasePresenter;
import com.latte.core.mvp.view.BaseMvpFragment;
import com.latte.core.mvp.view.IBaseView;

/**
 * @author 345 QQ:1831712732
 * @name MvpFrame
 * @class name：com.latte.core.mvp.mvpdefault
 * @time 2019/9/10 21:53
 * @description 默认的mvp 实现接口
 */
public class DefaultContract {
    public interface IDefaultView extends IBaseView{
        void onResult( boolean flag, String result);
    }
    public interface IDefaultPresenter extends IBasePresenter<IDefaultView>{
        void request(BaseMvpFragment mvpFragment, String url, String p);
    }
}
