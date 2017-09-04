package com.onenine.template;

import android.view.View;

/**
 * Created by xuchunlei on 2017/9/4.
 */

public interface TemplateInflateListener {

    /**
     * 绑定视图
     * <p>
     *     初始化实际的布局或视图
     * </p>
     * @param type
     * @param view
     */
    void onInflateView(int type, View view);
}
