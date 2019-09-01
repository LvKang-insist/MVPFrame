package com.latte.test.test;


import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.latte.core.mvp.model.BaseModel;
import com.latte.core.mvp.presenter.BasePresenter;
import com.latte.core.mvp.view.BaseMvpActivity;
import com.latte.core.mvp.view.BaseMvpFragment;

public class TestPresenterImpl extends BasePresenter<TestContract.TestView,TestModel> implements TestContract.TextPresenter {

    private TestModel<String> model;

    @Override
    protected TestModel attachModel() {
        return new TestModel();
    }
    @Override
    public void request(String msg) {
        model = new ViewModelProvider.NewInstanceFactory().create(TestModel.class);
        model.request(msg).observe((BaseMvpFragment) getView(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                getView().update(s);
                getView().dismissDialog();
            }
        });
    }

    public void upLiveData(String msg) {
        getView().showDialog();
        model.request(msg);
    }
}
