package tn.formalab.ecommerce.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.formalab.ecommerce.models.Product;
import tn.formalab.ecommerce.repositories.ProductRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("products")
public class ProductController {
    ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    @GetMapping(path = "all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = this.productRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping(path = "one/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        try {
            Product product = productRepository.findById(id).get();
            return ResponseEntity.status(HttpStatus.OK).body(product);

        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Product());
        }
    }

    @PostMapping(path ="add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product savedProduct = this.productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @PatchMapping(path="update")
    public ResponseEntity<Product> updateProductById(@RequestBody Product product)
    {Product updateProduct=this.productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(updateProduct);
    }

    @DeleteMapping(path="delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,String>> deleteProduct(@PathVariable Integer id)
    {
        this.productRepository.deleteById(id);

        HashMap<String,String> objet=new HashMap<>();
        objet.put("message","product deleted successfully");
        return ResponseEntity.status(HttpStatus.OK).body(objet);

    }




}
