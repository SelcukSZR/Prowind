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
import com.progon.prowind.persistence.CategoryRepository;

import java.util.ArrayList;

public class CategoryFragment extends Fragment {
    private static volatile CategoryFragment instance;

    public static CategoryFragment GetInstance() {
        if (instance == null){
            instance = new CategoryFragment();
        }
        return instance;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.category_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        CategoryRepository repository = DomainService.GetCategoryRepository();
        ArrayList<Category> categories = new ArrayList<Category>(repository.GetAll());
        CategoryViewAdapter adapter = new CategoryViewAdapter(getActivity(),0, categories);
        final ListView listview = (ListView) getView().findViewById(R.id.categoryList);
        listview.setAdapter(adapter);
    }
}