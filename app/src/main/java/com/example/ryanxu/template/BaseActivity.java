package com.example.ryanxu.template;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.onenine.template.TemplateInflateListener;
import com.onenine.template.TemplateStick;
import com.onenine.template.refresh.IRefreshContainer;

/**
 * Created by xuchunlei on 2017/9/4.
 */

public abstract class BaseActivity extends AppCompatActivity implements TemplateInflateListener{

    private final int[] TEMPLATE_ATTRS = new int[] {
            com.ryanx.onenine.template.R.attr.enable_spring,
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        injectInflater();
        super.onCreate(savedInstanceState);

        TemplateStick.init(this);
    }


    private void injectInflater() {
        // 自定义LayoutInflater的Factory，用于处理框架定义的属性
        LayoutInflaterCompat.setFactory(LayoutInflater.from(this), new LayoutInflaterFactory() {
            @Override
            public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
                AppCompatDelegate delegate = getDelegate();
                View v = delegate.createView(parent, name, context, attrs);

                if(v != null && parent instanceof IRefreshContainer) {
                    final TypedArray a = obtainStyledAttributes(attrs, TEMPLATE_ATTRS, com.ryanx.onenine.template.R.attr.enable_spring, 0);
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
    }
}
