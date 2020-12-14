package com.progon.prowind.infrastructure.data.api.context;

import com.progon.prowind.domain.Category;
import com.progon.prowind.infrastructure.data.IDataContext;
import com.progon.prowind.infrastructure.data.api.IApiCallback;
import com.progon.prowind.infrastructure.data.api.IApiDataProvider;
import com.progon.prowind.infrastructure.serialization.ISerializer;

public class CategoryApiContext implements IDataContext<Category> {
    private IApiDataProvider apiDataProvider;
    private String apiRoute;
    private ISerializer<Category> serializer;

    public CategoryApiContext(IApiDataProvider ApiDataProvider, String ApiRoute, ISerializer<Category> Serializer){
        this.apiDataProvider = ApiDataProvider;
        this.apiRoute = ApiRoute;
        this.serializer = Serializer;
    }

    @Override
    public void GetAll(final IApiCallback Callback) {
        apiDataProvider.MakeGetAllRequest(apiRoute, Callback);
    }

    @Override
    public Category GetById(int Id) {
        return serializer.DeserializeObject(apiDataProvider.MakeGetRequest(apiRoute + "/" + Id));
    }

    @Override
    public void Insert(Category Category) {
        apiDataProvider.MakePostRequest(apiRoute, serializer.SerializeObject(Category));
    }

    @Override
    public void Update(Category Category) {
        apiDataProvider.MakePutRequest(apiRoute, serializer.SerializeObject(Category));
    }

    @Override
    public void Delete(Category Category) {
        apiDataProvider.MakeDeleteRequest(apiRoute, serializer.SerializeObject(Category));
    }
}