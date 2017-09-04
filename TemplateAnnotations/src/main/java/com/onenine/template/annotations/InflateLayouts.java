package com.onenine.template.annotations;

import android.support.annotation.LayoutRes;

/**
 * 填充注解
 * <p>
 *     运行时获取填充模版的布局资源
 * </p>
 * Created by xuchunlei on 2017/9/4.
 */

public @interface InflateLayouts {
    @LayoutRes int[] value() default { Constants.NO_LAYOUT };
}
