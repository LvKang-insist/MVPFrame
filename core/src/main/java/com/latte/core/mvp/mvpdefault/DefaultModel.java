package com.latte.core.mvp.mvpdefault;

import androidx.lifecycle.MutableLiveData;

import com.latte.core.mvp.model.BaseModel;

/**
 * @author 345 QQ:1831712732
 * @name MvpFrame
 * @class name：com.latte.core.mvp.mvpdefault
 * @time 2019/9/10 21:56
 * @description M层的默认实现，如果fragment或者activity中没有过多的数据需要处理，则可以直接使用这个M层
 */
public class DefaultModel extends BaseModel {

    private MutableLiveData<String> mLiveData;

    @Override
    public MutableLiveData request(String url, Object... objects) {
        if (mLiveData == null){
            mLiveData = new MutableLiveData<>();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                    mLiveData.postValue("请求成功");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return mLiveData;
    }
}
