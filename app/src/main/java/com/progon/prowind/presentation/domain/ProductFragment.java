package com.progon.prowind.presentation.domain;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.progon.prowind.R;
import com.progon.prowind.application.DomainService;
import com.progon.prowind.domain.Order;
import com.progon.prowind.domain.Product;
import com.progon.prowind.persistence.OrderRepository;
import com.progon.prowind.persistence.ProductRepository;

import java.util.ArrayList;

public class ProductFragment extends Fragment {
    private static volatile ProductFragment instance;

    public static ProductFragment GetInstance() {
        if (instance == null){
            instance = new ProductFragment();
        }
        return instance;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.order_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ProductRepository repository = DomainService.GetProductRepository();
        ArrayList<Product> products = new ArrayList<Product>(repository.GetAll());
        ProductViewAdapter adapter = new ProductViewAdapter(getActivity(),0, products);
        final ListView listview = (ListView) getView().findViewById(R.id.orderList);
        listview.setAdapter(adapter);
    }
}