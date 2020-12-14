package com.progon.prowind.infrastructure.data.api.context;

import com.progon.prowind.domain.Product;
import com.progon.prowind.infrastructure.data.IDataContext;
import com.progon.prowind.infrastructure.data.api.IApiCallback;
import com.progon.prowind.infrastructure.data.api.IApiDataProvider;
import com.progon.prowind.infrastructure.serialization.ISerializer;

public class ProductApiContext implements IDataContext<Product> {
    private IApiDataProvider apiDataProvider;
    private String apiRoute;
    private ISerializer<Product> serializer;

    public ProductApiContext(IApiDataProvider ApiDataProvider, String ApiRoute, ISerializer<Product> Serializer){
        this.apiDataProvider = ApiDataProvider;
        this.apiRoute = ApiRoute;
        this.serializer = Serializer;
    }

    @Override
    public void GetAll(final IApiCallback Callback) {
        apiDataProvider.MakeGetAllRequest(apiRoute, Callback);
    }

    @Override
    public Product GetById(int Id) {
        return serializer.DeserializeObject(apiDataProvider.MakeGetRequest(apiRoute + "/" + Id));
    }

    @Override
    public void Insert(Product Product) {
        apiDataProvider.MakePostRequest(apiRoute, serializer.SerializeObject(Product));
    }

    @Override
    public void Update(Product Product) {
        apiDataProvider.MakePutRequest(apiRoute, serializer.SerializeObject(Product));
    }

    @Override
    public void Delete(Product Product) {
        apiDataProvider.MakeDeleteRequest(apiRoute, serializer.SerializeObject(Product));
    }
}
