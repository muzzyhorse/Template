package com.example.ryanxu.template;

import android.view.View;
import android.widget.TextView;

import com.ryanx.onenine.template.SingleTemplateActivity;

/**
 * Created by Ryan.Xu on 2017/9/1.
 */

public class SingleTextActivity extends SingleTemplateActivity {

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
