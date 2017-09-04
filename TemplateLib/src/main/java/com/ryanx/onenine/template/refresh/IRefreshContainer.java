package com.ryanx.onenine.template.refresh;

import android.view.View;

/**
 * 刷新容器接口
 * <p>
 *     定义支持界面回弹、下拉刷新和加载更多的行为
 * </p>
 *
 * Created by xuchunlei on 2017/9/2.
 */

public interface IRefreshContainer {

    /**
     * 结束刷新数据
     * @return
     */
    IRefreshContainer finalizeRefresh();

    /**
     * 结束加载更多
     * @return
     */
    IRefreshContainer finalizeLoadMore();

    /**
     * 设置回弹模式
     * <p>
     *     回弹模式下，只支持越界滚动，而不具备刷新数据和加载更多功能
     * </p>
     * @param spring
     * @return
     */
    IRefreshContainer setSpringMode(boolean spring);

    /**
     * 设置刷新内容
     * @param content
     * @return
     */
    IRefreshContainer setRefreshContent(View content);
}
