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
    
    static class ViewHolder{
        TextView text;
        ImageView icon;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup viewGroup) {
        
        ViewHolder viewHolder;
        LayoutInflater li= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        if(convertView==null){
            convertView=li.inflate(R.layout.drawer_item, null)
            
            viewHolder=new vievHolder();
            viewHolder.text=(TextView)convertView.findViewById(R.id.icon_text);
            viewHolder.icon=(ImageView)convertView.findViewById(R.id.icon_image);
            
            convertView.setTag(viewHolder);
            
            
        }
        
        ImageView imageView=new ImageView(mContext);
        imageView.setImageDrawable(pacsForAdapter[pos].icon);
        imageView.setLayoutParams(new GridView.LayoutParams(65,65));
        imageView.setPadding(3,3,3,3);
        return imageView;
    }
}
