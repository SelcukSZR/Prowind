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
import com.progon.prowind.domain.Category;
import com.progon.prowind.domain.Customer;
import com.progon.prowind.persistence.CategoryRepository;
import com.progon.prowind.persistence.CustomerRepository;

import java.util.ArrayList;

public class CustomerFragment extends Fragment {
    private static volatile CustomerFragment instance;

    public static CustomerFragment GetInstance() {
        if (instance == null){
            instance = new CustomerFragment();
        }
        return instance;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.customer_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        CustomerRepository repository = DomainService.GetCustomerRepository();
        ArrayList<Customer> customers = new ArrayList<Customer>(repository.GetAll());
        CustomerViewAdapter adapter = new CustomerViewAdapter(getActivity(),0, customers);
        final ListView listview = (ListView) getView().findViewById(R.id.customerList);
        listview.setAdapter(adapter);
    }
}