package com.progon.prowind.presentation.domain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.progon.prowind.R;

public class DomainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domain);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(OrderFragment.GetInstance());
    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_order:
                            openFragment(OrderFragment.GetInstance());
                            return true;
                        case R.id.navigation_category:
                            openFragment(CategoryFragment.GetInstance());
                            return true;
                        case R.id.navigation_product:
                            openFragment(ProductFragment.GetInstance());
                            return true;
                        case R.id.navigation_customer:
                            openFragment(CustomerFragment.GetInstance());
                            return true;
                        case R.id.navigation_supplier:
                            openFragment(SupplierFragment.GetInstance());
                            return true;
                    }
                    return false;
                }
            };
}