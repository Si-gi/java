package com.example.todolist;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {

    ArrayList<Item> items = new ArrayList<Item>();

    public ItemAdapter(Context context, int textViewResourceId, ArrayList<Item> objects) {
        super(context, textViewResourceId, objects);
        items = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_todo,parent, false);
        }

        ItemViewHolder viewHolder = (ItemViewHolder) convertView.getTag();

        if(viewHolder == null){
            viewHolder = new ItemViewHolder();
            viewHolder.text = (TextView) convertView.findViewById(R.id.task_title);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'Item [position] de la List<Item> tweets
        Item item = getItem(position);
        viewHolder.text.setText(item.getText()+" "+item.getDate());


        return convertView;
    }

    private class ItemViewHolder{
        public TextView text;


    }
}
