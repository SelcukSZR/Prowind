package com.progon.prowind.persistence;

import com.progon.prowind.domain.Supplier;
import com.progon.prowind.infrastructure.data.IDataContext;
import com.progon.prowind.infrastructure.data.api.IApiCallback;
import com.progon.prowind.infrastructure.serialization.JSerializer;

import java.util.ArrayList;
import java.util.List;

public class SupplierRepository implements IRepository<Supplier> {
    private IDataContext<Supplier> dataContext;
    private List<Supplier> suppliers = new ArrayList<Supplier>();

    public SupplierRepository(IDataContext<Supplier> DataContext){
        this.dataContext = DataContext;
        Initialize();
    }

    private void Initialize() {
        dataContext.GetAll(new IApiCallback() {
            @Override
            public void onSuccess(String Result) {
                suppliers = new JSerializer<Supplier>().DeserializeCollection(Result);
            }
            @Override
            public void onError(String Result) {
                suppliers = new ArrayList<Supplier>();
            }
        });
    }

    @Override
    public List<Supplier> GetAll() {
        return suppliers;
    }

    @Override
    public Supplier GetById(int Id) {
        return dataContext.GetById(Id);
    }

    @Override
    public void Insert(Supplier Supplier) {
        dataContext.Insert(Supplier);
    }

    @Override
    public void Update(Supplier Supplier) {
        dataContext.Update(Supplier);
    }

    @Override
    public void Delete(Supplier Supplier) {
        dataContext.Delete(Supplier);
    }
}
