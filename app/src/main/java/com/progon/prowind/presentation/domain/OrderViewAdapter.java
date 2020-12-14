package com.progon.prowind.presentation.domain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.progon.prowind.R;
import com.progon.prowind.domain.Order;

import java.util.ArrayList;

public class OrderViewAdapter extends ArrayAdapter<Order> {

    public OrderViewAdapter(Context context, int textViewResourceId, ArrayList<Order> items) {
        super(context, textViewResourceId, items);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.getContext())
                    .inflate(R.layout.order_view_adapter, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.HeaderText = (TextView) convertView.findViewById(R.id.header);
            viewHolder.DetailText = (TextView) convertView.findViewById(R.id.detail);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Order order = new Gson().fromJson(new Gson().toJson((getItem(position))), Order.class);
        if (order != null) {
            viewHolder.HeaderText.setText("Order Id : " + String.valueOf(order.id));
            viewHolder.DetailText.setText("Order Date : " + order.orderDate.toString());
        }
        return convertView;
    }

    static class ViewHolder {
        private TextView HeaderText;
        private TextView DetailText;
    }
}