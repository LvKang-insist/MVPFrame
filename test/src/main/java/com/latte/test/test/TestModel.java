package com.latte.test.test;

import androidx.lifecycle.MutableLiveData;

import com.latte.core.latte.Latte;
import com.latte.core.mvp.model.BaseModel;

public class TestModel<T> extends BaseModel {
    @Override
    public MutableLiveData<T> request(String url, Object... objects) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    Latte.getHandler().post(new Runnable() {
                        @Override
                        public void run() {
                            String aa = "哈哈";
                            getLiveData().postValue((T)aa);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return getLiveData();
    }

}
