package com.progon.prowind.presentation.domain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.gson.Gson;
import com.progon.prowind.R;
import com.progon.prowind.domain.Product;
import com.progon.prowind.domain.Supplier;

import java.util.ArrayList;

public class SupplierViewAdapter extends ArrayAdapter<Supplier> {

    public SupplierViewAdapter(Context context, int textViewResourceId, ArrayList<Supplier> items) {
        super(context, textViewResourceId, items);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        final SupplierViewAdapter.ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.getContext())
                    .inflate(R.layout.supplier_view_adapter, parent, false);
            viewHolder = new SupplierViewAdapter.ViewHolder();
            viewHolder.HeaderText = (TextView) convertView.findViewById(R.id.header);
            viewHolder.DetailText = (TextView) convertView.findViewById(R.id.detail);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (SupplierViewAdapter.ViewHolder) convertView.getTag();
        }
        Supplier supplier = new Gson().fromJson(new Gson().toJson((getItem(position))), Supplier.class);
        if (supplier != null) {
            viewHolder.HeaderText.setText("Supplier Company : " + String.valueOf(supplier.companyName));
            viewHolder.DetailText.setText("Contact : " + String.valueOf(supplier.contactName));
        }
        return convertView;
    }

    static class ViewHolder {
        private TextView HeaderText;
        private TextView DetailText;
    }
}