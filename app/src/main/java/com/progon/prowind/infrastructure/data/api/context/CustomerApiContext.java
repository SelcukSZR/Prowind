package com.progon.prowind.infrastructure.data.api.context;

import com.progon.prowind.domain.Customer;
import com.progon.prowind.infrastructure.data.IDataContext;
import com.progon.prowind.infrastructure.data.api.IApiCallback;
import com.progon.prowind.infrastructure.data.api.IApiDataProvider;
import com.progon.prowind.infrastructure.serialization.ISerializer;

public class CustomerApiContext implements IDataContext<Customer> {
    private IApiDataProvider apiDataProvider;
    private String apiRoute;
    private ISerializer<Customer> serializer;

    public CustomerApiContext(IApiDataProvider ApiDataProvider, String ApiRoute, ISerializer<Customer> Serializer){
        this.apiDataProvider = ApiDataProvider;
        this.apiRoute = ApiRoute;
        this.serializer = Serializer;
    }

    @Override
    public void GetAll(final IApiCallback Callback) {
        apiDataProvider.MakeGetAllRequest(apiRoute, Callback);
    }

    @Override
    public Customer GetById(int Id) {
        return serializer.DeserializeObject(apiDataProvider.MakeGetRequest(apiRoute + "/" + Id));
    }

    @Override
    public void Insert(Customer Customer) {
        apiDataProvider.MakePostRequest(apiRoute, serializer.SerializeObject(Customer));
    }

    @Override
    public void Update(Customer Customer) {
        apiDataProvider.MakePutRequest(apiRoute, serializer.SerializeObject(Customer));
    }

    @Override
    public void Delete(Customer Customer) {
        apiDataProvider.MakeDeleteRequest(apiRoute, serializer.SerializeObject(Customer));
    }
}
