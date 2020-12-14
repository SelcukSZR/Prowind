package com.progon.prowind.infrastructure.serialization;

import java.util.List;

public interface ISerializer<T> {
    String SerializeObject(T Object);
    T DeserializeObject(String String);
    String SerializeCollection(List<T> Collection);
    List<T> DeserializeCollection(String String);
}
