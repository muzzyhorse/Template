package com.ryanx.onenine.template.core;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

/**
 * 抽象模板活动
 * <p>
 *     所有模板活动的基类
 * </p>
 * Created by Ryan.Xu on 2017/9/1.
 */

public abstract class AbsTemplateActivity extends AppCompatActivity {

    /**
     * 获取模板布局资源
     * @return
     */
    @LayoutRes
    protected abstract int getTemplateResource();

    protected abstract void onBindView(int type, View view);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getTemplateResource());

        //注意这个vGroup并不是activity.xml中定义的根布局， mRootView才是。
        ViewGroup contentContainer = (ViewGroup) getWindow().getDecorView().findViewById(android.R.id.content);
        View contentV = contentContainer.getChildAt(0);
        if(contentV == null) {
            throw new IllegalStateException("Current Activity's content view can not be null, please check or restart your app");
        }

        if(contentV instanceof ViewStub) {
            handleViewStub((ViewStub)contentV);
        }else {
            ViewGroup contentVG = (ViewGroup)contentContainer.getChildAt(0);
            final int viewCount = contentVG.getChildCount();
            for(int i = 0;i < viewCount;i++) {
                View childV = contentVG.getChildAt(i);
                if(childV instanceof ViewStub) {
                    ViewStub stub = (ViewStub)childV;
                    handleViewStub(stub);
                }
            }
        }
    }

    private void handleViewStub(ViewStub stub) {

        if(stub.getLayoutResource() > 0 ) {
            View inflatedV = stub.inflate();
            onBindView(stub.getInflatedId() != View.NO_ID ? stub.getInflatedId() : inflatedV.getId(), inflatedV);
        }else {
            onBindView(stub.getId(), stub);
        }
    }
}
