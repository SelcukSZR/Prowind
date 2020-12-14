package com.progon.prowind.infrastructure.data;

import com.progon.prowind.infrastructure.data.api.IApiCallback;

public interface IDataContext<T> {
    void GetAll(IApiCallback Callback);
    T GetById(int Id);
    void Insert(T T);
    void Update(T T);
    void Delete(T T);
}
