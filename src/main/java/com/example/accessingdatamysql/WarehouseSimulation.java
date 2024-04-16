package com.example.accessingdatamysql;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WarehouseSimulation {

    private double getRandomDouble( int inMinimum, int inMaximum ) {

        double number = ( Math.random() * ( (inMaximum-inMinimum) + 1 )) + inMinimum;
        double rounded = Math.round(number * 100.0) / 100.0;
        return rounded;

    }

    private int getRandomInt( int inMinimum, int inMaximum ) {

        double number = ( Math.random() * ( (inMaximum-inMinimum) + 1 )) + inMinimum;
        Long rounded = Math.round(number);
        return rounded.intValue();

    }

    public void getData( WarehouseRepository warehouseRepository) {

        String[][] produkte = {
                {"Apfel", "Obst", "Stück"},
                {"Banane", "Obst", "Stück"},
                {"Karotte", "Gemüse", "Stück"},
                {"Tomate", "Gemüse", "Stück"},
                {"Huhn", "Fleisch", "Gramm"},
                {"Lachs", "Fisch", "Gramm"},
                {"Milch", "Milchprodukte", "Liter"},
                {"Käse", "Milchprodukte", "Gramm"},
                {"Brot", "Backwaren", "Stück"},
                {"Reis", "Getreideprodukte", "Gramm"},
                {"Ei", "Eier", "Stück"},
                {"Joghurt", "Milchprodukte", "Gramm"},
                {"Zucker", "Backwaren", "Gramm"},
                {"Kartoffel", "Gemüse", "Stück"},
                {"Erdbeere", "Obst", "Stück"}
        };

        Warehouse data = new Warehouse();
        data.setWarehouseName("Warehouse ");
        data.setWarehouseCity( "Linz" );
        data.setWarehouseAddress("Bahnhofsstrasse 27/9");
        data.setWarehousePostalCode("4020");
        data.setWarehouseCountry("Austria");

        List<Product> products = new ArrayList<>();

        for(int i = 0;i<10;i++){
            Product product = new Product();

            Random rand = new Random();
            int index = rand.nextInt(produkte.length);

            String[] randomProduct = produkte[index];

            product.setProductName(randomProduct[0]);
            product.setProductCategory(randomProduct[1]);
            product.setProductUnit(randomProduct[2]);

            int randomQuantity = rand.nextInt(501);
            product.setProductQuantity(String.valueOf(randomQuantity));

            products.add(product);

        }
        data.setProducts(products);

        warehouseRepository.save(data);
    }
}
