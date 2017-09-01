package com.example.ryanxu.template;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ryan.Xu on 2017/9/1.
 */

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.ViewHolder> implements View.OnClickListener {

    private List<DemoItem> demos;

    public DemoAdapter(List<DemoItem> demos) {
        this.demos = demos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView itemV = new TextView(parent.getContext());
        itemV.setPadding(20, 20, 20, 20);
        itemV.setGravity(Gravity.CENTER_VERTICAL);
        itemV.setOnClickListener(this);
        return new ViewHolder(itemV);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DemoItem demo = demos.get(position);
        ((TextView)holder.itemView).setText(demo.toString());
        holder.itemView.setTag(demo);
    }

    @Override
    public int getItemCount() {
        return demos != null ? demos.size() : 0;
    }

    @Override
    public void onClick(View view) {
        final Context context = view.getContext();
        DemoItem item = (DemoItem) view.getTag();
        Intent i = new Intent();
        i.setClassName(context.getPackageName(), item.className);
        context.startActivity(i);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
