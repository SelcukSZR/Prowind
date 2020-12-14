package com.progon.prowind.infrastructure.data.api.context;

import com.progon.prowind.domain.Supplier;
import com.progon.prowind.infrastructure.data.IDataContext;
import com.progon.prowind.infrastructure.data.api.IApiCallback;
import com.progon.prowind.infrastructure.data.api.IApiDataProvider;
import com.progon.prowind.infrastructure.serialization.ISerializer;

public class SupplierApiContext implements IDataContext<Supplier> {
    private IApiDataProvider apiDataProvider;
    private String apiRoute;
    private ISerializer<Supplier> serializer;

    public SupplierApiContext(IApiDataProvider ApiDataProvider, String ApiRoute, ISerializer<Supplier> Serializer){
        this.apiDataProvider = ApiDataProvider;
        this.apiRoute = ApiRoute;
        this.serializer = Serializer;
    }

    @Override
    public void GetAll(final IApiCallback Callback) {
        apiDataProvider.MakeGetAllRequest(apiRoute, Callback);
    }

    @Override
    public Supplier GetById(int Id) {
        return serializer.DeserializeObject(apiDataProvider.MakeGetRequest(apiRoute + "/" + Id));
    }

    @Override
    public void Insert(Supplier Supplier) {
        apiDataProvider.MakePostRequest(apiRoute, serializer.SerializeObject(Supplier));
    }

    @Override
    public void Update(Supplier Supplier) {
        apiDataProvider.MakePutRequest(apiRoute, serializer.SerializeObject(Supplier));
    }

    @Override
    public void Delete(Supplier Supplier) {
        apiDataProvider.MakeDeleteRequest(apiRoute, serializer.SerializeObject(Supplier));
    }
}
