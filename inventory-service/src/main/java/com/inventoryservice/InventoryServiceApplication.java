package com.inventoryservice;

import com.inventoryservice.model.Inventory;
import com.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
        return args -> {
            Inventory inventory1 = new Inventory() ;
            inventory1.setSkuCode("iphone13_mini");
            inventory1.setQuantity(100);

            Inventory inventory2 = new Inventory() ;
            inventory2.setSkuCode("iphone13_pro_max");
            inventory2.setQuantity(15);

            inventoryRepository.save(inventory1) ;
            inventoryRepository.save(inventory2) ;
        } ;
    }
}
