package com.example.ryanxu.template;

import android.view.View;
import android.widget.TextView;

import com.ryanx.onenine.template.refresh.RefreshTemplateActivity;

/**
 * Created by xuchunlei on 2017/9/2.
 */

public class RefreshTextActivity extends RefreshTemplateActivity {

    @Override
    protected int getContentResource() {
        return R.layout.activity_text;
    }

    @Override
    protected void initContent(View content) {
        setTitle(SingleTextActivity.class.getSimpleName());
        ((TextView)content).setText(SingleTextActivity.class.getSimpleName());
    }
}
