package com.progon.prowind.persistence;

import com.progon.prowind.domain.Order;
import com.progon.prowind.infrastructure.data.IDataContext;
import com.progon.prowind.infrastructure.data.api.IApiCallback;
import com.progon.prowind.infrastructure.serialization.JSerializer;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements IRepository<Order> {
    private IDataContext<Order> dataContext;
    private List<Order> orders = new ArrayList<Order>();

    public OrderRepository(IDataContext<Order> DataContext) {
        this.dataContext = DataContext;
        Initialize();
    }

    private void Initialize(){
        dataContext.GetAll(new IApiCallback() {
            @Override
            public void onSuccess(String Result) {
                orders = new JSerializer<Order>().DeserializeCollection(Result);
            }
            @Override
            public void onError(String Result) {
                orders = new ArrayList<Order>();
            }
        });
    }

    @Override
    public List<Order> GetAll() {
        return orders;
    }

    @Override
    public Order GetById(int Id) {
        return dataContext.GetById(Id);
    }

    @Override
    public void Insert(Order Order) {
        dataContext.Insert(Order);
    }

    @Override
    public void Update(Order Order) {
        dataContext.Update(Order);
    }

    @Override
    public void Delete(Order Order) {
        dataContext.Delete(Order);
    }
}
