package com.example.accessingdatamysql;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.ProtectionDomain;
import java.util.List;
import java.util.Optional;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {

    @Autowired
    private  WarehouseRepository warehouseRepository;

    @PostMapping(path="/add")
    public @ResponseBody void generateWarehouses() {
        WarehouseSimulation ws = new WarehouseSimulation();
        ws.getData(warehouseRepository);

        System.out.println("Add");
    }

    @GetMapping(path="/list")
    public @ResponseBody Iterable<Warehouse> getAllWarehouses() {
        System.out.println("List");
        return warehouseRepository.findAll();
    }

    /*
    @PostMapping(path="/products/datawarehouse")
    public @ResponseBody List<Product> getProductsByDataWarehouseId(@RequestParam int dataWarehouseId) {
        return productRepository.findByDataWarehouseId(String.valueOf(dataWarehouseId));
    }

    @GetMapping(path="/product")
    public @ResponseBody ResponseEntity<?> getProductByDataWarehouseAndProductId(@RequestParam int dataWarehouseId, @RequestParam int productId) {
        Optional<Product> product = productRepository.findByIdAndDataWarehouseId(String.valueOf(productId), String.valueOf(dataWarehouseId));
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping(path="/update/datawarehouse")
    public @ResponseBody ResponseEntity<String> updateDataWarehouse(@RequestParam int dataWarehouseId, @RequestParam String name) {
        productRepository.updateDataWarehouse(dataWarehouseId, name);
        return ResponseEntity.ok("Data Warehouse updated successfully.");
    }*/
}