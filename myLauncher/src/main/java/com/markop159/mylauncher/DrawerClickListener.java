package com.markop159.mylauncher;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class DrawerClickListener implements OnItemClickListener {

	Context mContext;
	MainActivity.Pac[] pacsForAdapter;
	PackageManager pmForListener;

	public DrawerClickListener(Context c, MainActivity.Pac[] pacs, PackageManager pm){
		mContext=c;
		pacsForAdapter=pacs;
		pmForListener=pm;
	}

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
    	if (MainActivity.appLauchable){
        	Intent launchIntent=pmForListener.getLaunchIntentForPackage(pacsForAdapter[pos].name);
        	mContext.startActivity(launchIntent);
    	}
    }
}
