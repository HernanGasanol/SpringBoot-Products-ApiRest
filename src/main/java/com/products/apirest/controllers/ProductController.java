package com.products.apirest.controllers;

import com.products.apirest.models.Product;
import com.products.apirest.repository.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value="/api")
@Api(value = "API REST products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping(value="/products")
    @ApiOperation(value = "return a list of products")
    public List<Product> list(){
        return productRepository.findAll();
    }

    @GetMapping(value="/product/{id}")
    @ApiOperation(value = "returns a one product searched by id")
    public Product product(@PathVariable(value = "id") long id ){
        return productRepository.findById(id);
    }


    @PostMapping(value = "/product")
    @ApiOperation(value = "return a one product searched by id")
    public  Product createProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @DeleteMapping(value="/product/{id}")
    @ApiOperation(value = "return a one product searched by id")
    public void deleteProduct(@PathVariable(value="id") long id){
        productRepository.deleteById(id);

    }

    @PutMapping(value = "/product")
    @ApiOperation(value = "return a one product searched by id")
    public Product updateProduct( @RequestBody Product product){

       return productRepository.save(product);

    }

}
