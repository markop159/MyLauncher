package com.markop159.mylauncher;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SlidingDrawer;
import android.widget.RelativeLayout;
import android.widget.AdapterView.OnItemLongClickListener;

public class DrawerLongClickListener implements OnItemLongClickListener {
  
  Context mContext;
  SlidingDrawer drawerForAdapter;
  RelativeLayout homeViewForAdapter;
  
  
  public DrawerLongClickListener(Context ctxt, SlidingDrawer slidingDrawer, RelativeLayout homeView){
    mContext=ctxt;
    drawerForAdapter=slidingDrawer;
    homeViewForAdapter=homeView;
    
  }
  
  @Override
    public void onItemLongClick(AdapterView<?> arg0, View item, int arg2, long arg3) {
      
      MainActivity.appLaunchable=false;
        
      LayoutParams lp= new LayoutParams(item.getWidth(),item.getHeight())
      lp.leftMargin=(int) item.getX();
      lp.topMargin=(int) item.getY();
        
      LayoutInflater li= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      LinearLayout ll= (LinearLayout) li.inflate(R.layout.drawer item,null);
        
      ((ImageView)ll.findViewById(R.id.icon_image)).setImageDrawable(((ImageView)item.findViewById(R.id.icon_image)).getDrawable());
      ((TextView)ll.findViewById(R.id.icon_text)).setText(((TextView)item.findViewById(R.id.icon_text)).getText());
        
      homeViewForAdapter.addView(ll,lp);
      drawerForAdapter.animateClose();
      drawerForAdapter.bringToFront();
        
      return false;
    }

}
