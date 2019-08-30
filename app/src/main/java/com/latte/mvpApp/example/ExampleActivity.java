package com.latte.mvpApp.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.latte.core.mvp.factory.CreatePresenter;
import com.latte.core.mvp.view.BaseMvpActivity;
import com.latte.mvpApp.R;
/**
 * @author 345 QQ:1831712732
 * @name MvpFrame
 * @class name：com.latte.mvpApp.example
 * @time 2019/8/30 17:12
 * @description 主Activity
 */
@CreatePresenter(ExamplePersenter.class)
public class ExampleActivity extends BaseMvpActivity<ExamplePersenter> implements ExampleContract.IExampleView {

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void BindView() {

    }

}
