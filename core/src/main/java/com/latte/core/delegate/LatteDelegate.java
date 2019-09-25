package com.latte.core.delegate;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.latte.core.R;
import com.latte.core.R2;
import com.latte.core.mvp.presenter.IBasePresenter;
import com.latte.core.mvp.view.BaseMvpFragment;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import butterknife.BindView;

/**
 * @author 345 QQ:1831712732
 * @name MvpFrame
 * @class name：com.latte.core.delegate
 * @time 2019/9/5 21:07
 * @description
 */

public abstract class LatteDelegate<P extends IBasePresenter> extends BaseMvpFragment implements View.OnClickListener {

    @BindView(R2.id.bottom_bar)
    LinearLayoutCompat mBottomBar = null;

    /**
     * 存储所有的子 Fragment
     */
    private final ArrayList<BaseMvpFragment> ITEM_DELEGATES = new ArrayList<>();
    /**
     * 存储所有的子 TabBean
     */
    private final ArrayList<BottomTabBean> TAB_BEANS = new ArrayList<>();

    /**
     * 默认显示的delegate
     */
    private int mIndexDelegate = 0;

    /**
     * 存储 Fragment和TabBean 的映射
     */
    private final LinkedHashMap<BottomTabBean, BaseMvpFragment> ITEMS = new LinkedHashMap<>();

    /**
     * 记录上一次点击的 item
     */
    public RelativeLayout item;

    public abstract LinkedHashMap<BottomTabBean, BaseMvpFragment> setItems(ItemBuilder builder);

    public abstract int startDelegate();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIndexDelegate = startDelegate();
        //拿到工厂类的实例
        final ItemBuilder builder = ItemBuilder.builder();
        //获取 添加完成的键值对
        final LinkedHashMap<BottomTabBean, BaseMvpFragment> items = setItems(builder);
        //将 键值对 保存在ITEMS 中
        ITEMS.putAll(items);
        //拿到键和值
        for (Map.Entry<BottomTabBean, BaseMvpFragment> item : ITEMS.entrySet()) {
            final BottomTabBean key = item.getKey();
            final BaseMvpFragment value = item.getValue();
            TAB_BEANS.add(key);
            ITEM_DELEGATES.add(value);
        }
    }


    @Override
    public Object setLayout() {
        return R.layout.delegate_bottom;
    }

    @Override
    public void BindView(View view) {
        mBottomBar.setBackgroundColor(Color.RED);
        final int size = ITEMS.size();
        for (int i = 0; i < size; i++) {
            //第一个参数 布局，第二个参数 为给第一个参数加载的布局 设置一个父布局
            LayoutInflater.from(getContext()).inflate(R.layout.bottom_item_icon_text_layout, mBottomBar);
            //返回指定的视图
            final RelativeLayout item = (RelativeLayout) mBottomBar.getChildAt(i);
            item.setOnClickListener(this);
            //设置每个 item的点击事件 和标记
            item.setTag(i);
//            item.setOnClickListener(this);
            //拿到 item 的第一个和 第二个子布局
            final AppCompatTextView itemIcon = (AppCompatTextView) item.getChildAt(0);
            final AppCompatTextView itemTitle = (AppCompatTextView) item.getChildAt(1);

            //获取 集合中对应的 Tab
            final BottomTabBean bean = TAB_BEANS.get(i);

            //初始化 tab 数据
            itemIcon.setText(bean.getIcon().toString());
            itemTitle.setText(bean.getTitle());
            if (i == mIndexDelegate){
                itemIcon.setTextColor(Color.RED);
                itemTitle.setTextColor(Color.RED);
            }
        }
        //默认打开的delegate
//        setTab(mBottomBar.getChildAt(pos));
        getSupportDelegate().loadRootFragment(R.id.bottom_bar_delegate_container,ITEM_DELEGATES.get(mIndexDelegate));
    }

    @Override
    public void onClick(View view) {
//        setTab(view);
    }
/*
    protected void setTab(View tab) {
        defaultTab();
        this.item = (RelativeLayout) tab;
        final AppCompatTextView itemIcon = (AppCompatTextView) item.getChildAt(0);
        final AppCompatTextView itemTitle = (AppCompatTextView) item.getChildAt(1);
        itemIcon.setTextColor(Color.RED);
        itemTitle.setTextColor(Color.RED);
    }

    protected void defaultTab() {
        if (item != null) {
            final AppCompatTextView itemIcon = (AppCompatTextView) item.getChildAt(0);
            final AppCompatTextView itemTitle = (AppCompatTextView) item.getChildAt(1);
            itemIcon.setTextColor(Color.GRAY);
            itemTitle.setTextColor(Color.GRAY);
        }
    }*/
}
