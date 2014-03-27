package com.markop159.myLauncher;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class DrawerClickListener implements OnItemClickListener {

	Context mContext;
	MainActivity.Pac[] pacsForAdapter;
	PackageManager pmForListener;

	public DrawerClickListener(Context c, MainActivity.Pac[] acs, PackageManager pm){
		mContext=c;
		pacsForAdapter=pacs;
		pmForListener=pm;
	}

	public void onItemClick(AdapterView<?> arg0, view arg1, int pos, long arg3){
		Intent launchIntent =pmForListener.getLaunchIntentForPackage(packageForAdapter[pos].name);
		mContext.startActivity(launchIntent);
	}
	
}
