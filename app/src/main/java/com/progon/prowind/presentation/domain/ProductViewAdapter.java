package com.progon.prowind.presentation.domain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.gson.Gson;
import com.progon.prowind.R;
import com.progon.prowind.domain.Order;
import com.progon.prowind.domain.Product;

import java.util.ArrayList;

public class ProductViewAdapter extends ArrayAdapter<Product> {

    public ProductViewAdapter(Context context, int textViewResourceId, ArrayList<Product> items) {
        super(context, textViewResourceId, items);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        final ProductViewAdapter.ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.getContext())
                    .inflate(R.layout.product_view_adapter, parent, false);
            viewHolder = new ProductViewAdapter.ViewHolder();
            viewHolder.HeaderText = (TextView) convertView.findViewById(R.id.header);
            viewHolder.DetailText = (TextView) convertView.findViewById(R.id.detail);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ProductViewAdapter.ViewHolder) convertView.getTag();
        }
        Product product = new Gson().fromJson(new Gson().toJson((getItem(position))), Product.class);
        if (product != null) {
            viewHolder.HeaderText.setText("Product Name : " + String.valueOf(product.name));
            viewHolder.DetailText.setText("In Stock : " + String.valueOf(product.unitsInStock));
        }
        return convertView;
    }

    static class ViewHolder {
        private TextView HeaderText;
        private TextView DetailText;
    }
}