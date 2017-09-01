package com.example.ryanxu.template;

/**
 * Created by Ryan.Xu on 2017/9/1.
 */

public class DemoItem {
    public String demoName;
    public String className;

    public DemoItem(String demoName, String className) {
        this.demoName = demoName;
        this.className = className;
    }

    @Override
    public String toString() {
        return demoName;
    }
}
