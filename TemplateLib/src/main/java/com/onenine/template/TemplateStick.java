package com.onenine.template;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

import com.onenine.template.annotations.InflateLayouts;
import com.onenine.template.annotations.TemplateLayout;

/**
 * Created by xuchunlei on 2017/9/4.
 */

public final class TemplateStick {

    private static final String TAG = "TemplateStick";

    public static final int NO_LAYOUT = 0;

    private TemplateStick(){

    }


    public static void init(Activity activity) {

        Class<?> clazz = activity.getClass();
        final @LayoutRes int templateRes = TemplateStick.findTemplate(clazz);
        if(templateRes > TemplateStick.NO_LAYOUT) {
            activity.setContentView(templateRes);

            ViewGroup contentContainer = (ViewGroup) activity.getWindow().getDecorView().findViewById(android.R.id.content);
            View contentV = contentContainer.getChildAt(0);
            if(contentV == null) {
                throw new IllegalStateException("Current Activity's content view can not be null, please check or restart your app");
            }

            TemplateStick.load(clazz, contentV, (TemplateInflateListener) activity);
        }else {
            final @LayoutRes int[] contentRes = TemplateStick.findContents(clazz);
            if(contentRes != null && contentRes.length > 0) {
                activity.setContentView(contentRes[0]);
            }else {
                throw new IllegalArgumentException("either supplying a content layout resource with InflateLayouts annotation," +
                        " or override the onCreate method to setContentView");
            }
        }

    }

    /**
     * 加载模版
     * @param clazz
     * @param contentV
     * @param listener
     */
    public static void load(Class<?> clazz, View contentV, TemplateInflateListener listener) {

        @LayoutRes int[] layouts = findContents(clazz);

        if(contentV instanceof ViewStub) {
            if(layouts == null) {
                throw new IllegalArgumentException("you should supply a inflate layout resources for template");
            }else {
                handleViewStub((ViewStub)contentV, layouts[0], listener);
            }

        }else {
            ViewGroup contentVG = (ViewGroup)contentV;
            final int viewCount = contentVG.getChildCount();
            if(layouts == null) {
                throw new IllegalArgumentException("you should supply some inflate layout resources for template");
            }else {
                int j = 0;
                for(int i = 0;i < viewCount;i++) {
                    View childV = contentVG.getChildAt(i);
                    if(childV instanceof ViewStub) {
                        ViewStub stub = (ViewStub)childV;
                        handleViewStub(stub, layouts[j++], listener);
                    }
                }
            }

        }
    }

    /**
     * 查找类使用的模版
     * @param clazz
     * @return
     */
    private static @LayoutRes int findTemplate(Class<?> clazz) {
        if(clazz.isAnnotationPresent(TemplateLayout.class)){
            TemplateLayout template = clazz.getAnnotation(TemplateLayout.class);
            return template.value();
        }
        return NO_LAYOUT;
    }

    /**
     * 查找类使用的内容布局
     * @param clazz
     * @return
     */
    private static @LayoutRes int[] findContents(Class<?> clazz) {
        @LayoutRes int[] layouts = null;
        if(clazz.isAnnotationPresent(InflateLayouts.class)){
            InflateLayouts inflates = clazz.getAnnotation(InflateLayouts.class);
            layouts = inflates.value();
        }
        return layouts;
    }


    /**
     * 处理模版视图中的ViewStub
     * @param stub
     * @param listener
     */
    private static void handleViewStub(ViewStub stub, @LayoutRes int layout, TemplateInflateListener listener) {

        if(stub.getLayoutResource() > NO_LAYOUT) {
            Log.i(TAG, "stub #" + stub.getId() + " has a default layout resource #" + stub.getLayoutResource());
        }else {
            stub.setLayoutResource(layout);
        }
        View inflatedV = stub.inflate();
        if(listener != null) {
            listener.onInflateView(stub.getInflatedId() != View.NO_ID ? stub.getInflatedId() : inflatedV.getId(), inflatedV);
        }
    }
}
