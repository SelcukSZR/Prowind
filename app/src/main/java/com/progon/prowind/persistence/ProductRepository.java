package com.progon.prowind.persistence;

import com.progon.prowind.domain.Product;
import com.progon.prowind.infrastructure.data.IDataContext;
import com.progon.prowind.infrastructure.data.api.IApiCallback;
import com.progon.prowind.infrastructure.serialization.JSerializer;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IRepository<Product> {
    private IDataContext<Product> dataContext;
    private List<Product> products = new ArrayList<Product>();

    public ProductRepository(IDataContext<Product> DataContext){
        this.dataContext = DataContext;
        Initialize();
    }

    private void Initialize(){
        dataContext.GetAll(new IApiCallback() {
            @Override
            public void onSuccess(String Result) {
                products = new JSerializer<Product>().DeserializeCollection(Result);
            }
            @Override
            public void onError(String Result) {
                products = new ArrayList<Product>();
            }
        });
    }

    @Override
    public List<Product> GetAll() {
        return products;
    }

    @Override
    public Product GetById(int Id) {
        return dataContext.GetById(Id);
    }

    @Override
    public void Insert(Product Product) {
        dataContext.Insert(Product);
    }

    @Override
    public void Update(Product Product) {
        dataContext.Update(Product);
    }

    @Override
    public void Delete(Product Product) {
        dataContext.Delete(Product);
    }
}
