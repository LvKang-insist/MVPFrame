package com.latte.test.test;


import com.latte.core.mvp.model.BaseModel;
import com.latte.core.mvp.presenter.BasePresenter;

public class TestPresenterImpl extends BasePresenter<TestContract.TestView,TestModel> implements TestContract.TextPresenter {

    @Override
    protected TestModel attachModel() {
        return new TestModel();
    }
    @Override
    public void request(String msg) {
        getView().showDialog();
        getModel().request(msg, new BaseModel.onRequestDataListener() {
            @Override
            public void onRequest(String msg) {
                if (getView()!= null){
                    getView().update(msg);
                    getView().dismissDialog();
                }
            }
        });
    }



}
