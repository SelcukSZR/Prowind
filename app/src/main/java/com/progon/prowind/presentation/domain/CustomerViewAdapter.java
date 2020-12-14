package com.progon.prowind.presentation.domain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.gson.Gson;
import com.progon.prowind.R;
import com.progon.prowind.domain.Category;
import com.progon.prowind.domain.Customer;

import java.util.ArrayList;

public class CustomerViewAdapter extends ArrayAdapter<Customer> {

    public CustomerViewAdapter(Context context, int textViewResourceId, ArrayList<Customer> items) {
        super(context, textViewResourceId, items);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        final CustomerViewAdapter.ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.getContext())
                    .inflate(R.layout.customer_view_adapter, parent, false);
            viewHolder = new CustomerViewAdapter.ViewHolder();
            viewHolder.HeaderText = (TextView) convertView.findViewById(R.id.header);
            viewHolder.DetailText = (TextView) convertView.findViewById(R.id.detail);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (CustomerViewAdapter.ViewHolder) convertView.getTag();
        }
        Customer customer = new Gson().fromJson(new Gson().toJson((getItem(position))), Customer.class);
        if (customer != null) {
            viewHolder.HeaderText.setText("Customer Name : " + String.valueOf(customer.companyName));
            viewHolder.DetailText.setText("Address : " + String.valueOf(customer.address.city));
        }
        return convertView;
    }

    static class ViewHolder {
        private TextView HeaderText;
        private TextView DetailText;
    }
}