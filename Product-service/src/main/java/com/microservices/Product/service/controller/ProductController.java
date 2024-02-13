package com.microservices.Product.service.controller;

import com.microservices.Product.service.dto.ProductRequest;
import com.microservices.Product.service.dto.ProductResponse;
import com.microservices.Product.service.services.ProductService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        System.out.println("product_request:"+productRequest);
        productService.createProduct(productRequest);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts()
    {
       return  productService.getAllProducts();
    }

}
