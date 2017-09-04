package com.ryanx.onenine.template;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewStub;

import com.ryanx.onenine.template.core.AbsTemplateActivity;

/**
 * 单一布局模板活动
 * Created by Ryan.Xu on 2017/9/1.
 */

public abstract class SingleTemplateActivity extends AbsTemplateActivity {

    @Override
    protected int getTemplateResource() {
        return R.layout.template_single;
    }

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
    protected void onInflateView(int type, View view) {
        ViewStub stub = (ViewStub)view;
        @LayoutRes int layout = getContentResource();
        if(layout > 0) {
            stub.setLayoutResource(layout);
            initContent(stub.inflate());
        }
    }
}
