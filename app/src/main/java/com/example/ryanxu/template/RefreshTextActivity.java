package com.example.ryanxu.template;

import android.view.View;
import android.widget.TextView;

import com.onenine.template.annotations.InflateLayouts;
import com.onenine.template.annotations.TemplateLayout;

/**
 * Created by xuchunlei on 2017/9/2.
 */

@TemplateLayout(R.layout.template_refresh)
@InflateLayouts(R.layout.activity_text)
public class RefreshTextActivity extends BaseActivity {

    @Override
    public void onInflateView(int type, View view) {
        setTitle(SingleTextActivity.class.getSimpleName());
        ((TextView)view).setText(SingleTextActivity.class.getSimpleName());
    }
}
