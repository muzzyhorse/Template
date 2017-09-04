package com.example.ryanxu.template;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.onenine.template.annotations.InitMethod;
import com.onenine.template.annotations.InflateLayouts;
import com.onenine.template.annotations.TemplateLayout;

/**
 * Created by Ryan.Xu on 2017/9/1.
 */

@TemplateLayout(R.layout.template_single)
@InflateLayouts(R.layout.activity_text)
public class SingleTextActivity extends BaseActivity {


    @Override
    public void onInflateView(int type, View view) {
        setTitle(SingleTextActivity.class.getSimpleName());
        ((TextView)view).setText(SingleTextActivity.class.getSimpleName());
    }

    @InitMethod(R.layout.activity_text)
    void initContent(View view) {
        Log.e("xuchunlei", "inside initContent " + view.getClass().getSimpleName());
    }

}
