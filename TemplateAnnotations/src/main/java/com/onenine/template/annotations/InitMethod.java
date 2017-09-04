package com.onenine.template.annotations;

import android.support.annotation.LayoutRes;

/**
 * Created by xuchunlei on 2017/9/3.
 */

public @interface InitMethod {

    @LayoutRes int value() default Constants.NO_LAYOUT;
}
