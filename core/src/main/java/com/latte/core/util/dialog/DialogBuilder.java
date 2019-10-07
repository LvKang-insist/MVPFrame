package com.latte.core.util.dialog;

/**
 * Created by Administrator on 2019/10/7.
 */

@SuppressWarnings("WeakerAccess")
public class DialogBuilder {


    private Object view;
    private float mAlpha = 1;
    private boolean mAutoDismiss = false;
    private boolean mCancelable = true;


    /**
     * 设置布局资源，可以为 ID，也可以是 View
     */
    public DialogBuilder setContentView(Object view) {
        this.view = view;
        return this;
    }

    /**
     * 设置透明度透明度
     *
     * @param alpha 从 0 - 1
     */
    public DialogBuilder setAlpha(float alpha) {
        this.mAlpha = alpha;
        return this;
    }




    /**
     * 若为 true 所有的点击事件都不起作用，否则相反
     */
    public DialogBuilder setAutoDismiss(boolean autoDismiss) {
        this.mAutoDismiss = autoDismiss;
        return this;
    }

    /**
     * 若为 false，对话框不可取消
     */
    public DialogBuilder setCancelable(boolean cancelable) {
        this.mCancelable = cancelable;
        return this;
    }



    /**
     * @return 对话框的实例
     */
    public CustomDialog build() {
        return CustomDialog.newInstance(view, mAlpha, mAutoDismiss, mCancelable);
    }
}
