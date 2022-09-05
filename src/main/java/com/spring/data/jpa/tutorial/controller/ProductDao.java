package com.spring.data.jpa.tutorial.controller;

import com.spring.data.jpa.tutorial.entity.Product;
import com.spring.data.jpa.tutorial.repository.ProductRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class ProductDao {

    public static final Logger logger = LoggerFactory.getLogger(ProductDao.class);
    @Autowired
    ProductRepo productRepo;
    //Service which will do all data retrieval/manipulation work

    // -------------------Create a Product-------------------------------------------
    @RequestMapping(value = "/products/", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity createProduct(@RequestBody Product product) throws SQLException, ClassNotFoundException {
        logger.info("Creating Product : {}", product);

        productRepo.save(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }


    // -------------------Retrieve All Products--------------------------------------------

    @RequestMapping(value = "/products/", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Product>> listAllProducts() throws SQLException, ClassNotFoundException {
        List<Product> products = productRepo.findAll();

//        if (books.isEmpty()) {
//            return new ResponseEntity(books, HttpStatus.NOT_FOUND);x
//        }
        ResponseEntity responseEntity = new ResponseEntity(products, HttpStatus.OK);
        return responseEntity;
    }

    // -------------------Retrieve A Product--------------------------------------------

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Product>> getProduct(@PathVariable("id") Long id) throws SQLException, ClassNotFoundException {
        Optional<Product> products = productRepo.findById(id);

//        if (books.isEmpty()) {
//            return new ResponseEntity(books, HttpStatus.NOT_FOUND);
//        }
        ResponseEntity responseEntity = new ResponseEntity(products, HttpStatus.OK);
        return responseEntity;
    }


    // ------------------- Delete All Products-----------------------------

    @RequestMapping(value = "/products/", method = RequestMethod.DELETE)
    public ResponseEntity<Product> deleteAllProducts() throws SQLException, ClassNotFoundException {
        logger.info("Deleting All Products");

        productRepo.deleteAll();
        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
    }//Sampai sini aman

    // ------------------- Delete a Product-----------------------------
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Product> deleteaProduct (@PathVariable("id") Long id) throws SQLException, ClassNotFoundException  {
        logger.info("Deleting A Product");

        productRepo.deleteById(id);
        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
    }

}


