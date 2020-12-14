package com.progon.prowind.infrastructure.serialization;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JSerializer<T> implements ISerializer {
    @Override
    public String SerializeObject(Object Object) {
        return new Gson().toJson(Object);
    }

    @Override
    public T DeserializeObject(String String) {
        Type type = new TypeToken<T>(){}.getType();
        return new Gson().fromJson(String, type);
    }

    @Override
    public String SerializeCollection(List Collection) {
        return SerializeObject(Collection);
    }

    @Override
    public List<T> DeserializeCollection(String String) {
        Type type = new TypeToken<ArrayList<T>>(){}.getType();
        return new Gson().fromJson(String, type);
    }
}