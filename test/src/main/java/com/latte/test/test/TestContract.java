package com.latte.test.test;

import com.latte.core.mvp.presenter.IBasePresenter;
import com.latte.core.mvp.view.IBaseView;

public class TestContract {

    public interface TestView extends IBaseView {
        void showDialog();
        void dismissDialog();
        void update(String msg);
    }

    public interface TextPresenter extends IBasePresenter<TestView> {
        void request(String msg);
    }
}
