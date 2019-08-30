package com.latte.core.mvp.model;

/**
 * @author 345 QQ:1831712732
 * @name MvpFrame
 * @class name：com.latte.core.mvp.model
 * @time 2019/8/30 17:12
 * @description 抽象 M 层 需要被继承，默认一个请求数据的方法，可重写或者重载，也可以自定义
 */
public abstract class BaseModel {

    /**
     * 一个接口，在 M 层请求数据后可以将数据传递到 P层，最终更新 View
     * 如果需要使用 则重写
     */
    public interface onRequestDataListener {
        void onRequest(String msg);
    }

    /**
     * 如果需要请求数据，则重写该方法，或者重新定义一个方法
     */
    public void request(String json, onRequestDataListener listener) {

    }
}
