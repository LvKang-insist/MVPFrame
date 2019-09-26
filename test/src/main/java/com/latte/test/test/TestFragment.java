/*
package com.latte.test.test;

import android.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import com.latte.core.delegate.BottomTabBean;
import com.latte.core.delegate.ItemBuilder;
import com.latte.core.mvp.factory.CreatePresenter;
import com.latte.core.mvp.mvpdefault.DefaultContract;
import com.latte.core.mvp.mvpdefault.DefaultPresenterImpl;
import com.latte.core.mvp.view.BaseMvpFragment;
import com.latte.test.R;

import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.LinkedHashMap;


@CreatePresenter(DefaultPresenterImpl.class)
public class TestFragment extends LatteDelegate<DefaultPresenterImpl> implements DefaultContract.IDefaultView {

    private AlertDialog alertDialog;

    @Override
    public LinkedHashMap<BottomTabBean, BaseMvpFragment> setItems(ItemBuilder builder) {
//        builder.addItem(new BottomTabBean("haha","hah"),new TextOne());
        return builder.build();
    }

    @Override
    public int startDelegate() {
        return 0;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
*/
