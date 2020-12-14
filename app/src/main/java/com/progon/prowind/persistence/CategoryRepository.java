package com.progon.prowind.persistence;

import com.progon.prowind.domain.Category;
import com.progon.prowind.infrastructure.data.IDataContext;
import com.progon.prowind.infrastructure.data.api.IApiCallback;
import com.progon.prowind.infrastructure.serialization.JSerializer;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements IRepository<Category> {
    private IDataContext<Category> dataContext;
    private List<Category> categories = new ArrayList<Category>();

    public CategoryRepository(IDataContext<Category> DataContext){
        this.dataContext = DataContext;
        Initialize();
    }

    private void Initialize(){
        dataContext.GetAll(new IApiCallback() {
            @Override
            public void onSuccess(String Result) {
                categories = new JSerializer<Category>().DeserializeCollection(Result);
            }
            @Override
            public void onError(String Result) {
                categories = new ArrayList<Category>();
            }
        });
    }

    @Override
    public List<Category> GetAll() {
        return categories;
    }

    @Override
    public Category GetById(int Id) {
        return dataContext.GetById(Id);
    }

    @Override
    public void Insert(Category Category) {
        dataContext.Insert(Category);
    }

    @Override
    public void Update(Category Category) {
        dataContext.Update(Category);
    }

    @Override
    public void Delete(Category Category) {
        dataContext.Delete(Category);
    }
}
