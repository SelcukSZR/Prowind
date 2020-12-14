package com.progon.prowind.presentation.domain;

import androidx.fragment.app.ListFragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.progon.prowind.R;
import com.progon.prowind.application.DomainService;
import com.progon.prowind.domain.Order;
import com.progon.prowind.infrastructure.data.api.context.OrderApiContext;
import com.progon.prowind.persistence.OrderRepository;

import java.util.ArrayList;

public class OrderFragment extends Fragment {
    private static volatile OrderFragment instance;

    public static OrderFragment GetInstance() {
        if (instance == null){
            instance = new OrderFragment();
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
        OrderRepository repository = DomainService.GetOrderRepository();
        ArrayList<Order> orders = new ArrayList<Order>(repository.GetAll());
        OrderViewAdapter adapter = new OrderViewAdapter(getActivity(),0, orders);
        final ListView listview = (ListView) getView().findViewById(R.id.orderList);
        listview.setAdapter(adapter);
    }
}