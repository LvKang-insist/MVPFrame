package com.latte.core.util.dialog;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.DialogFragment;

import com.latte.core.R;

import java.util.Objects;

/**
 * Created by Administrator on 2019/10/7.
 */

public class CustomDialog extends DialogFragment {

    private Object mView;
    private View mRootView;
    private float mAlpha ;
    private boolean mAutoDismiss;
    private boolean mCancelable;
    private Window window;

    private SparseArray<OnListener> mClickArray;
    private SparseArray<String> mSetText;

    private CustomDialog(Object view, float alpha, boolean autoDismiss, boolean cancelable) {
        this.mView = view;
        this.mAlpha = alpha;
        this.mAutoDismiss = autoDismiss;
        this.mCancelable = cancelable;
        mClickArray = new SparseArray();
        mSetText = new SparseArray<>();
    }

    public static CustomDialog newInstance(Object view, float alpha,
                                           boolean mAutoDismiss, boolean cancelable) {
        return new CustomDialog(view, alpha, mAutoDismiss, cancelable);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        window = Objects.requireNonNull(getDialog()).getWindow();
        if (window != null) {
            if (mView instanceof Integer) {
                this.mRootView = inflater.inflate((Integer) mView, window.findViewById(android.R.id.content), false);
            } else if (mView instanceof View) {
                this.mRootView = (View) mView;
            } else {
                throw new NullPointerException("Not Layout File ");
            }
            create();
            window.setWindowAnimations(R.style.BottomAnimStyle);
        }
        return mRootView;
    }

    public static DialogBuilder Builder() {
        return new DialogBuilder();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mSetText!=null) {
            mSetText.clear();
            mSetText = null;
        }
        if (mClickArray!=null) {
            mClickArray.clear();
            mClickArray = null;
        }
    }

    /**
     * 对点击事件进行处理
     */
    private  final class ViewOnClick implements View.OnClickListener {
        private final CustomDialog dialog;
        private final OnListener listener;

        ViewOnClick(CustomDialog dialog, OnListener listener) {
            this.dialog = dialog;
            this.listener = listener;
        }

        @Override
        public void onClick(View view) {
            if (!mAutoDismiss) {
                listener.onClick(dialog,view);
            }
        }
    }

    /**
     * 对事件进行监听，
     */
    public interface OnListener {
        void onClick(CustomDialog dialog, View view);
    }


    /**
     * 设置 文本
     *
     * @param Id      id
     * @param strings 内容
     */
    public CustomDialog setText(@IdRes int Id, String strings) {
        mSetText.put(Id, strings);
        return this;
    }

    /**
     * 监听事件
     */
    public CustomDialog setListener(int id, OnListener listener) {
        mClickArray.put(id, listener);
        return this;
    }


    private void setLocation() {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = mAlpha;
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        window.setAttributes(attributes);
    }


    private void create() {
        setLocation();
        setCancelable(mCancelable);
        for (int i = 0; i < mSetText.size(); i++) {
            View viewById = mRootView.findViewById(mSetText.keyAt(i));
            if (viewById instanceof AppCompatTextView) {
                ((AppCompatTextView) viewById).setText(mSetText.valueAt(i));
            } else if (viewById instanceof AppCompatButton) {
                ((AppCompatButton) viewById).setText(mSetText.valueAt(i));
            }
        }

        for (int i = 0; i < mClickArray.size(); i++) {
            mRootView.findViewById(mClickArray.keyAt(i))
                    .setOnClickListener(new ViewOnClick(this,mClickArray.valueAt(i)));
        }
    }
}
