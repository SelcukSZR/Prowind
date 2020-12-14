package com.progon.prowind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.progon.prowind.application.ApplicationService;
import com.progon.prowind.application.DomainService;
import com.progon.prowind.presentation.domain.DomainActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApplicationService appService = new ApplicationService(getApplicationContext());
        DomainService domainService = new DomainService(appService.GetDomainDataProvider());
    }

    public void OnLogoClick(View View){
        Intent intent = new Intent(this, DomainActivity.class);
        startActivity(intent);
    }
}