package com.progon.prowind.domain;

public class Product {
    public int id;
    public String quantityPerUnit;
    public double unitPrice;
    public double unitsInStock;
    public double unitsOnOrder;
    public int reorderLevel;
    public boolean discontinued;
    public String name;
    public Supplier supplier;
    public Category category;

}