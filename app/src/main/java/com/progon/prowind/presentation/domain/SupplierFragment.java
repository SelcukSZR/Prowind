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
import com.progon.prowind.domain.Product;
import com.progon.prowind.domain.Supplier;
import com.progon.prowind.persistence.ProductRepository;
import com.progon.prowind.persistence.SupplierRepository;

import java.util.ArrayList;

public class SupplierFragment extends Fragment {
    private static volatile SupplierFragment instance;

    public static SupplierFragment GetInstance() {
        if (instance == null){
            instance = new SupplierFragment();
        }
        return instance;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.supplier_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SupplierRepository repository = DomainService.GetSupplierRepository();
        ArrayList<Supplier> suppliers = new ArrayList<Supplier>(repository.GetAll());
        SupplierViewAdapter adapter = new SupplierViewAdapter(getActivity(),0, suppliers);
        final ListView listview = (ListView) getView().findViewById(R.id.supplierList);
        listview.setAdapter(adapter);
    }
}