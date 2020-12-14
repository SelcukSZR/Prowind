package com.progon.prowind.persistence;

import com.progon.prowind.domain.Customer;
import com.progon.prowind.infrastructure.data.IDataContext;
import com.progon.prowind.infrastructure.data.api.IApiCallback;
import com.progon.prowind.infrastructure.serialization.JSerializer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements IRepository<Customer> {
    private IDataContext<Customer> dataContext;
    private List<Customer> customers = new ArrayList<Customer>();

    public CustomerRepository(IDataContext<Customer> DataContext){
        this.dataContext = DataContext;
        Initialize();
    }

    private void Initialize(){
        dataContext.GetAll(new IApiCallback() {
            @Override
            public void onSuccess(String Result) {
                customers = new JSerializer<Customer>().DeserializeCollection(Result);
            }
            @Override
            public void onError(String Result) {
                customers = new ArrayList<Customer>();
            }
        });
    }

    @Override
    public List<Customer> GetAll() {
        return customers;
    }

    @Override
    public Customer GetById(int Id) {
        return dataContext.GetById(Id);
    }

    @Override
    public void Insert(Customer Customer) {
        dataContext.Insert(Customer);
    }

    @Override
    public void Update(Customer Customer) {
        dataContext.Update(Customer);
    }

    @Override
    public void Delete(Customer Customer) {
        dataContext.Delete(Customer);
    }
}
