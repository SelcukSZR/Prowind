package com.progon.prowind.infrastructure.data.api;

public interface IApiCallback {
    void onSuccess(String Result);
    void onError(String Result);
}
