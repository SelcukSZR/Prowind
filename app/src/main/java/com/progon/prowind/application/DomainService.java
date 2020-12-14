package com.progon.prowind.application;

import com.progon.prowind.domain.Category;
import com.progon.prowind.domain.Customer;
import com.progon.prowind.domain.Order;
import com.progon.prowind.domain.Product;
import com.progon.prowind.domain.Supplier;
import com.progon.prowind.infrastructure.data.IDataProvider;
import com.progon.prowind.infrastructure.data.api.IApiDataProvider;
import com.progon.prowind.infrastructure.data.api.context.CategoryApiContext;
import com.progon.prowind.infrastructure.data.api.context.CustomerApiContext;
import com.progon.prowind.infrastructure.data.api.context.OrderApiContext;
import com.progon.prowind.infrastructure.data.api.context.ProductApiContext;
import com.progon.prowind.infrastructure.data.api.context.SupplierApiContext;
import com.progon.prowind.infrastructure.serialization.JSerializer;
import com.progon.prowind.persistence.CategoryRepository;
import com.progon.prowind.persistence.CustomerRepository;
import com.progon.prowind.persistence.OrderRepository;
import com.progon.prowind.persistence.ProductRepository;
import com.progon.prowind.persistence.SupplierRepository;

public class DomainService {
    private static volatile OrderRepository orderRepository = null;
    private static volatile CategoryRepository categoryRepository = null;
    private static volatile CustomerRepository customerRepository = null;
    private static volatile ProductRepository productRepository = null;
    private static volatile SupplierRepository supplierRepository = null;
    private IApiDataProvider dataProvider;

    public DomainService(IDataProvider DataProvider){
        this.dataProvider = (IApiDataProvider) DataProvider;
        CreateRepositories();
    }

    public static OrderRepository GetOrderRepository(){
        return orderRepository;
    }

    public static CategoryRepository GetCategoryRepository(){
        return categoryRepository;
    }

    public static CustomerRepository GetCustomerRepository(){
        return customerRepository;
    }

    public static ProductRepository GetProductRepository(){
        return productRepository;
    }

    public static SupplierRepository GetSupplierRepository(){
        return supplierRepository;
    }

    private void CreateRepositories(){
        CreateOrderRepository();
        CreateCustomerRepository();
        CreateCategoryRepository();
        CreateProductRepository();
        CreateSupplierRepository();
    }

    private void CreateOrderRepository(){
        if (orderRepository == null) {
            OrderApiContext apiContext = new OrderApiContext(dataProvider, "orders", new JSerializer<Order>());
            orderRepository = new OrderRepository(apiContext);
            orderRepository.GetAll();
        }
    }

    private void CreateCategoryRepository(){
        if (categoryRepository == null) {
            CategoryApiContext apiContext = new CategoryApiContext(dataProvider, "categories", new JSerializer<Category>());
            categoryRepository = new CategoryRepository(apiContext);
            categoryRepository.GetAll();
        }
    }

    private void CreateCustomerRepository(){
        if (customerRepository == null) {
            CustomerApiContext apiContext = new CustomerApiContext(dataProvider, "customers", new JSerializer<Customer>());
            customerRepository = new CustomerRepository(apiContext);
            customerRepository.GetAll();
        }
    }

    private void CreateProductRepository(){
        if (productRepository == null) {
            ProductApiContext apiContext = new ProductApiContext(dataProvider, "products", new JSerializer<Product>());
            productRepository = new ProductRepository(apiContext);
            productRepository.GetAll();
        }
    }

    private void CreateSupplierRepository(){
        if (supplierRepository == null) {
            SupplierApiContext apiContext = new SupplierApiContext(dataProvider, "suppliers", new JSerializer<Supplier>());
            supplierRepository = new SupplierRepository(apiContext);
            supplierRepository.GetAll();
        }
    }
}
