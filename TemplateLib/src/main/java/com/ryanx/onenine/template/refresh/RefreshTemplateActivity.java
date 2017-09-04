package com.ryanx.onenine.template.refresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.AppCompatDelegate;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;

import com.ryanx.onenine.template.R;
import com.ryanx.onenine.template.core.AbsTemplateActivity;

/**
 * Created by xuchunlei on 2017/9/2.
 */

public abstract class RefreshTemplateActivity extends AbsTemplateActivity {

    private final int[] TEMPLATE_ATTRS = new int[] {
            R.attr.enable_spring,
    };


    /**
     * 获取内容布局资源
     * @return
     */
    @LayoutRes
    protected abstract int getContentResource();

    /**
     * 初始化内容视图
     * @param content
     */
    protected abstract void initContent(View content);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // 自定义LayoutInflater的Factory，用于处理框架定义的属性
        LayoutInflaterCompat.setFactory(LayoutInflater.from(this), new LayoutInflaterFactory() {
            @Override
            public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
                AppCompatDelegate delegate = getDelegate();
                View v = delegate.createView(parent, name, context, attrs);

                if(v != null && parent instanceof IRefreshContainer) {
                    final TypedArray a = obtainStyledAttributes(attrs, TEMPLATE_ATTRS, R.attr.enable_spring, 0);
                    boolean spring = a.getBoolean(0, false);
                    if(parent instanceof IRefreshContainer) {
                        IRefreshContainer container = (IRefreshContainer)parent;
                        container.setRefreshContent(v);
                        container.setSpringMode(spring);
                    }
                    a.recycle();
                }

                return v;
            }
        });
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getTemplateResource() {
        return R.layout.template_refresh;
    }

    @Override
    protected void onInflateView(int type, View view) {
        ViewStub stub = (ViewStub)view;
        @LayoutRes int layout = getContentResource();
        if(layout > 0) {
            stub.setLayoutResource(layout);
            initContent(stub.inflate());
        }
    }
}
