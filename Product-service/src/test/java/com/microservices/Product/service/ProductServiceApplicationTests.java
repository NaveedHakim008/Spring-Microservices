package com.microservices.Product.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.Product.service.dto.ProductRequest;
import com.microservices.Product.service.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.org.checkerframework.checker.units.qual.A;
import org.testcontainers.utility.DockerImageName;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {

    @Container
	static MongoDBContainer mongoDBContainer=new MongoDBContainer(DockerImageName.parse("mongo:latest"));

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	ProductRepository productRepository;
    static{
		mongoDBContainer.start();
	}




	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
		dynamicPropertyRegistry.add("spring.data.mongo.uri",mongoDBContainer::getReplicaSetUrl);
	}

	@Test
	void shouldCreateProduct() throws Exception{
      ProductRequest  productRequest=getProductRequest();
	  String productRequestString = objectMapper.writeValueAsString(productRequest);
       mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
			   .contentType(MediaType.APPLICATION_JSON_VALUE)
			   .content(productRequestString))
			   .andExpect(status().isCreated());
		Assertions.assertEquals(6,productRepository.findAll().size());

	}
	private ProductRequest getProductRequest()
	{
         return ProductRequest.builder().name("iphone 13").description("iphone 13").price(BigDecimal.valueOf(1200)).build();
	}

}
