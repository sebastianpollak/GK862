package com.example.accessingdatamysql;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
public class Warehouse {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String warehouseName;
    private String warehouseAddress;
    private String warehousePostalCode;
    private String warehouseCity;
    private String warehouseCountry;
    private String timestamp;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;

    /**
     * Constructor
     */
    public Warehouse() {

        this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        products = new ArrayList<>(10);
    }

    /**
     * Setter and Getter Methods
     */
    public int getId() {
        return id;
    }

    public void setId(int warehouseID) {
        this.id = warehouseID;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    public String getWarehousePostalCode() {
        return warehousePostalCode;
    }

    public void setWarehousePostalCode(String warehousePostalCode) {
        this.warehousePostalCode = warehousePostalCode;
    }

    public String getWarehouseCity() {
        return warehouseCity;
    }

    public void setWarehouseCity(String warehouseCity) {
        this.warehouseCity = warehouseCity;
    }

    public String getWarehouseCountry() {
        return warehouseCountry;
    }

    public void setWarehouseCountry(String warehouseCountry) {
        this.warehouseCountry = warehouseCountry;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * Methods
     */
    @Override
    public String toString() {
        String info = String.format("Warehouse Info: ID = %s, timestamp = %s", id, timestamp );
        return info;
    }
}