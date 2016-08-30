package com.javahelps.navigationdrawer.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.javahelps.navigationdrawer.R;
import com.javahelps.navigationdrawer.models.Illness;

import java.util.List;

/**
 * Created by Angelhia on 29/8/2016.
 */
public class PossibleIlnessListAdapter extends BaseAdapter {

    private List<Illness> list;
    private Activity activity;

    public PossibleIlnessListAdapter( Activity activity, List<Illness> list) {
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
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_illness, null);
            holder.illness = (TextView) convertView.findViewById(R.id.illness);
            holder.desc = (TextView) convertView.findViewById(R.id.illnessDes);
            holder.icon = (ImageView) convertView.findViewById(R.id.icon);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.illness.setText(list.get(position).getName());
        holder.desc.setText(list.get(position).getDesc());
        holder.icon.setImageResource(list.get(position).getImg());


        return convertView;
    }

    private class ViewHolder {
        private TextView illness;
        private TextView desc;
        private ImageView icon;
    }
}
