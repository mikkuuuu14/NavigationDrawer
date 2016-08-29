package com.javahelps.navigationdrawer.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.javahelps.navigationdrawer.R;

import java.util.List;

/**
 * Created by Angelhia on 29/8/2016.
 */
public class CustomListAdapter extends BaseAdapter {

    private List<String> list;
    private Activity activity;

    public CustomListAdapter( Activity activity, List<String> list) {
        this.list = list;
        this.activity = activity;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_list, null);
            holder.text = (TextView) convertView.findViewById(R.id.itemText);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.text.setText(list.get(position));

        return convertView;
    }

    private class ViewHolder {
        private TextView text;
    }
}
