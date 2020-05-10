package com.example.smsbomber;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdaptater extends ArrayAdapter<ContactModel> {

    private Context context;
    private ArrayList<ContactModel> contactModelArrayList;

    public ContactAdaptater(Context context, int textViewResourceId, ArrayList<ContactModel> contactModelArrayList) {
        super(context, textViewResourceId, contactModelArrayList);
        this.context = context;
        this.contactModelArrayList = contactModelArrayList;
    }

    @Override
    public int getCount() {
        return contactModelArrayList.size();
    }

    @Override
    public ContactModel getItem(int position) {
        return contactModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.contacts_list_item, null, true);

            holder.tvname = (TextView) convertView.findViewById(R.id.name);
            holder.tvnumber = (TextView) convertView.findViewById(R.id.number);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tvname.setText(contactModelArrayList.get(position).getName());
        holder.tvnumber.setText(contactModelArrayList.get(position).getNumber());

        return convertView;
    }

    private class ViewHolder {

        protected TextView tvname, tvnumber;

    }

}
