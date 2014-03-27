package com.markop159.mylauncher;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.GridView;

import java.util.List;

public class MainActivity extends Activity {

    DrawerAdapter drawerAdapterObject;

    GridView drawerGrid;

    class Pac{
        Drawable icon;
        String name;
        String label;
    }

    Pac[] pacs;
    PackageManager pm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        drawerGrid=(GridView) findViewById(R.id.content);

        pm=getPackageManager();
        set_packs();
        drawerAdapterObject=new DrawerAdapter(this,pacs);
        drawerGrid.setAdapter(drawerAdapterObject);
        drawerGrid.setOnItemClickListener(new DrawerClickListener(this, pacs, pm));
        
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_PACKAGE_ADDED);
        filter.addAction(Intent.ACTION_PACKAGE_REMOVED);
        filter.addAction(Intent.ACTION_PACKAGE_CHANGED);
        filter.addDataScheme("package");
        registerReceiver(new PacReceiver(),filter);

    }

    public void set_packs(){
        final Intent mainIntent=new Intent(Intent.ACTION_MAIN,null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> pacsList=pm.queryIntentActivities(mainIntent,0);
        pacs=new Pac[pacsList.size()];
        for(int i=0;i<pacsList.size();i++){
            pacs[i]=new Pac();
            pacs[i].icon=pacsList.get(i).loadIcon(pm);
            pacs[i].name=pacsList.get(i).activityInfo.packageName;
            pacs[i].label=pacsList.get(i).loadLabel(pm).toString();
        }
        new SortApps().exchange_sort(pacs);
    }
    
    public class PacReceiver extends BroadcastReceiver{
	    @Override
	    public void onReceive(context context, Intent intent){
		
	    }
    }

}
