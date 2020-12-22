package com.example.zodiacsign;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.ArrayList;

import Zodiac.Zodiac;

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<Zodiac> list;
    LayoutInflater inflater;


    public CustomAdapter(Context context, ArrayList<Zodiac> list) {
        this.context = context;
        this.list = list;
        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemHandler handler = null;
        if (convertView==null){
            convertView=inflater.inflate(R.layout.zod_lay,null);
            handler=new ItemHandler();
            handler.iv=convertView.findViewById(R.id.imageView1);
            handler.name=convertView.findViewById(R.id.lblName);
            handler.date=convertView.findViewById(R.id.lblDate);
            convertView.setTag(handler);
        }else handler=(ItemHandler) convertView.getTag();
        handler.iv.setImageResource(list.get(position).getImage());
        handler.name.setText(list.get(position).getName().toUpperCase());
        handler.date.setText(list.get(position).getDate());

        return convertView ;
    }

    static class ItemHandler{
        ImageView iv;
        TextView name, date;
    }

}
