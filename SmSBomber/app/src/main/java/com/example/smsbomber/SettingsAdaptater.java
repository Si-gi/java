package com.example.smsbomber;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.ArrayList;

public class SettingsAdaptater extends ArrayAdapter<SettingsModel> {
    private Context context;
    private ArrayList<SettingsModel> settingsModelArrayList;

    public SettingsAdaptater(Context context, int textViewResourceId, ArrayList<SettingsModel> settingsModelArrayList) {
        super(context, textViewResourceId, settingsModelArrayList);
        this.context = context;
        this.settingsModelArrayList = settingsModelArrayList;
    }

    @Override
    public int getCount() {
        return settingsModelArrayList.size();
    }

    @Override
    public SettingsModel getItem(int position) {
        return settingsModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SettingsAdaptater.ViewHolder holder;

        if (convertView == null) {
            holder = new SettingsAdaptater.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.contacts_list_item, null, true);

            holder.message = (TextView) convertView.findViewById(R.id.message);
            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (SettingsAdaptater.ViewHolder)convertView.getTag();
        }

        holder.message.setText(settingsModelArrayList.get(position).getMessage());


        return convertView;
    }

    private class ViewHolder {

        protected TextView message;

    }
}
