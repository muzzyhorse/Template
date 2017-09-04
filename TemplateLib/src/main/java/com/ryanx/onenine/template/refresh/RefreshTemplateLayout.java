package com.ryanx.onenine.template.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.impl.RefreshContentWrapper;

/**
 * Created by xuchunlei on 2017/9/2.
 */

public class RefreshTemplateLayout extends SmartRefreshLayout implements IRefreshContainer {

    public RefreshTemplateLayout(Context context) {
        this(context, null);
    }

    public RefreshTemplateLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RefreshTemplateLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public IRefreshContainer finalizeRefresh() {
        return (IRefreshContainer)finishRefresh();
    }

    @Override
    public IRefreshContainer finalizeLoadMore() {
        return (IRefreshContainer)finishLoadmore();
    }

    @Override
    public IRefreshContainer setSpringMode(boolean spring) {
        return (IRefreshContainer) setEnablePureScrollMode(spring);
    }

    @Override
    public IRefreshContainer setRefreshContent(View content) {
        mRefreshContent = new RefreshContentWrapper(content);
        return this;
    }


}
