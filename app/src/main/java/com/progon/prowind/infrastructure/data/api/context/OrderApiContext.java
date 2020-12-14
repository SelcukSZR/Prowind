package com.progon.prowind.infrastructure.data.api.context;

import com.progon.prowind.domain.Order;
import com.progon.prowind.infrastructure.data.IDataContext;
import com.progon.prowind.infrastructure.data.api.IApiCallback;
import com.progon.prowind.infrastructure.data.api.IApiDataProvider;
import com.progon.prowind.infrastructure.serialization.ISerializer;

public class OrderApiContext implements IDataContext<Order> {
    private IApiDataProvider apiDataProvider;
    private String apiRoute;
    private ISerializer<Order> serializer;

    public OrderApiContext(IApiDataProvider ApiDataProvider, String ApiRoute, ISerializer<Order> Serializer){
        this.apiDataProvider = ApiDataProvider;
        this.apiRoute = ApiRoute;
        this.serializer = Serializer;
    }

    @Override
    public void GetAll(final IApiCallback Callback) {
        apiDataProvider.MakeGetAllRequest(apiRoute, Callback);
    }

    @Override
    public Order GetById(int Id) {
        return serializer.DeserializeObject(apiDataProvider.MakeGetRequest(apiRoute + "/" + Id));
    }

    @Override
    public void Insert(Order Order) {
        apiDataProvider.MakePostRequest(apiRoute, serializer.SerializeObject(Order));
    }

    @Override
    public void Update(Order Order) {
        apiDataProvider.MakePutRequest(apiRoute, serializer.SerializeObject(Order));
    }

    @Override
    public void Delete(Order Order) {
        apiDataProvider.MakeDeleteRequest(apiRoute, serializer.SerializeObject(Order));
    }
}
