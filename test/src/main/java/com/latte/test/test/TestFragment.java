package com.latte.test.test;

import android.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import com.latte.core.R;
import com.latte.core.mvp.factory.CreatePresenter;
import com.latte.core.mvp.view.BaseMvpFragment;


@CreatePresenter(TestPresenterImpl.class)
public class TestFragment extends BaseMvpFragment<TestPresenterImpl> implements TestContract.TestView {

    private AlertDialog alertDialog;

    @Override
    public Object setLayout() {
        return R.layout.test;
    }

    @Override
    public void BindView(View view) {
        view.findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        alertDialog = new AlertDialog.Builder(getContext()).create();
        alertDialog.setMessage("网络请求中，请稍后");
        getPresenter().request("我是请求的参数");
    }

    @Override
    public void showDialog() {
        if (alertDialog != null) {
            alertDialog.show();
        }
    }

    @Override
    public void dismissDialog() {
        if (alertDialog != null) {
            alertDialog.cancel();
        }
    }

    @Override
    public void update(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

}
