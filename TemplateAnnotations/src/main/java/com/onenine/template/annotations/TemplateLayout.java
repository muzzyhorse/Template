package com.onenine.template.annotations;

import android.support.annotation.LayoutRes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 模版注解
 * <p>
 *     运行期获取使用的模版布局
 * </p>
 * Created by xuchunlei on 2017/9/4.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TemplateLayout {
    @LayoutRes int value() default 0;
}
