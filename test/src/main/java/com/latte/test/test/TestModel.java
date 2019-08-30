package com.latte.test.test;
import com.latte.core.latte.Latte;
import com.latte.core.mvp.model.BaseModel;

public class TestModel extends BaseModel {

    @Override
    public void request(String json, final BaseModel.onRequestDataListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    Latte.getHandler().post(new Runnable() {
                        @Override
                        public void run() {
                            listener.onRequest("请求成功，哈哈哈哈哈");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
