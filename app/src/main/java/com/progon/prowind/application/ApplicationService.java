package com.progon.prowind.application;

import android.content.Context;

import com.progon.prowind.infrastructure.conversion.DataConverter;
import com.progon.prowind.infrastructure.data.IDataProvider;
import com.progon.prowind.infrastructure.data.api.volley.VolleyConfiguration;
import com.progon.prowind.infrastructure.data.api.volley.VolleyDataProvider;
import com.progon.prowind.infrastructure.log.ILogService;
import com.progon.prowind.infrastructure.log.room.RoomLogService;

public class ApplicationService {
    private Context context;

    public ApplicationService(Context Context){
        this.context = Context;
    }

    public ILogService GetLogService(){
        return new RoomLogService(context, new DataConverter());
    }

    public IDataProvider GetDomainDataProvider(){
        VolleyConfiguration apiConfiguration = new VolleyConfiguration();
        apiConfiguration.ResponseTimeOut = 10;
        apiConfiguration.ApiUrl = "https://northwind.now.sh/api";
        VolleyDataProvider apiProvider = new VolleyDataProvider(context, apiConfiguration, GetLogService());
        return apiProvider;
    }
}