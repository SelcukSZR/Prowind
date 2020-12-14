package com.progon.prowind.persistence;

import java.util.List;

public interface IRepository<T> {
    List<T> GetAll();
    T GetById(int Id);
    void Insert(T T);
    void Update(T T);
    void Delete(T T);
}
