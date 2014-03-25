package com.markop159.mylauncher;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Marko on 25.3.2014.
 */
public class DrawerAdapter extends BaseAdapter{

    Context mContext;
    MainActivity.Pac[] pacsForAdapter;

    public DrawerAdapter(Context c,MainActivity.Pac pacs[]){

        mContext=c;
        pacsForAdapter=pacs;

    }

    @Override
    public int getCount() {
        return pacsForAdapter.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {
        ImageView imageView=new ImageView(mContext);
        imageView.setImageDrawable(pacsForAdapter[pos].icon);
        imageView.setLayoutParams(new GridView.LayoutParams(65,65));
        imageView.setPadding(3,3,3,3);
        return imageView;
    }
}
