package com.progon.prowind.domain;

import java.util.List;

public class Order {
    public int id;
    public String customerId;
    public int employeeId;
    public String orderDate;
    public String requiredDate;
    public String shippedDate;
    public int shipVia;
    public double freight;
    public String shipName;
    public Address shipAddress;
    public List<OrderDetail> details;
}