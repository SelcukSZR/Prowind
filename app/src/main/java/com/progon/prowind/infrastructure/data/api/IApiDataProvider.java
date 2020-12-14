package com.progon.prowind.infrastructure.data.api;

import com.progon.prowind.infrastructure.data.IDataProvider;

public interface IApiDataProvider extends IDataProvider {
    String MakeGetRequest(String Route);
    void MakeGetAllRequest(String Route, final IApiCallback Callback);
    String MakePostRequest(String Route, String Json);
    String MakePutRequest(String Route, String Json);
    String MakeDeleteRequest(String Route, String Json);
}
