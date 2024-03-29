package com.microservices.inventoryservice;

import com.microservices.inventoryservice.model.Inventory;
import com.microservices.inventoryservice.repository.InventoryRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
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
	public CommandLineRunner loadData(InventoryRepository inventoryRepository)
	{
		return args->{
			Inventory inventory =new Inventory();
			inventory.setQuantity(1300);
			inventory.setSkuCode("iphone_15");

			Inventory inventory1=new Inventory();
			inventory1.setQuantity(500);
			inventory1.setSkuCode("samsung_S24");

			inventoryRepository.save(inventory1);
			inventoryRepository.save(inventory);


	};
	}
}
