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
import com.progon.prowind.domain.Order;

import java.util.ArrayList;

public class CategoryViewAdapter extends ArrayAdapter<Category> {

    public CategoryViewAdapter(Context context, int textViewResourceId, ArrayList<Category> items) {
        super(context, textViewResourceId, items);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        final CategoryViewAdapter.ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.getContext())
                    .inflate(R.layout.category_view_adapter, parent, false);
            viewHolder = new CategoryViewAdapter.ViewHolder();
            viewHolder.HeaderText = (TextView) convertView.findViewById(R.id.header);
            viewHolder.DetailText = (TextView) convertView.findViewById(R.id.detail);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (CategoryViewAdapter.ViewHolder) convertView.getTag();
        }
        Category category = new Gson().fromJson(new Gson().toJson((getItem(position))), Category.class);
        if (category != null) {
            viewHolder.HeaderText.setText("Category Name : " + String.valueOf(category.name));
            viewHolder.DetailText.setText("Description : " + String.valueOf(category.description));
        }
        return convertView;
    }

    static class ViewHolder {
        private TextView HeaderText;
        private TextView DetailText;
    }
}