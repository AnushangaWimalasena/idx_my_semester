package com.ai.mysemesters.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ai.mysemesters.R;

import static com.ai.mysemesters.R.drawable.et_background;

public class ModuleAdapter extends BaseAdapter {

    private String [] modules;
    private  Integer [] colors;
    private Context mContext;
    LinearLayout view ;

    public ModuleAdapter(Context c, String[] dataModules, Integer [] color){
        mContext = c;
        //modules =  new String[dataModules.length];
        modules = dataModules;
        //colors =  new Integer[color.length];
        colors = color;


    }

    @Override
    public int getCount() {
        return modules.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        TextView view =  new TextView(mContext);
//        view.setLayoutParams(new GridView.LayoutParams(200, 200));
//
//        int x = position%colors.length;
//        //view.setBackground(et_background);
//        view.setPadding(10,10,10,10);
//
//
//        System.out.println(modules[position]);
//        System.out.println(colors[x]);
//        view.setText(modules[position]);


        return view;
    }
}
