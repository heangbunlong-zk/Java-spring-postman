package com.javaspring.a01a1webmvc.controller;

import com.javaspring.a01a1webmvc.dto.ProductCreateRequest;
import com.javaspring.a01a1webmvc.dto.ProductResponse;
import com.javaspring.a01a1webmvc.dto.UpdateProductRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @GetMapping
    public List<ProductResponse> getProducts(@RequestParam(required = false, defaultValue = "0") int PageNumber,
                                             @RequestParam(required = false, defaultValue = "20") int PageSie,
                                             @RequestParam(required = false, defaultValue = "")String name
    ) {
        log.info("Page number :{}, PageSize :{}, name: {}"
                , name
                , PageNumber
                , PageSie
        );

        return List.of();
    }

//    @GetMapping
//    public void ProductCreateRequest (
//            @RequestBody ProductCreateRequest productCreateRequest
//            ) {
//        log.info("CreateProductRequesr: {}", productCreateRequest);
//    }

    @PostMapping
    public void createNewProduct(
            @RequestBody ProductCreateRequest createProductRequest
    ){
       log.info("createProductRequest: {}", createProductRequest);
    }

    @PutMapping("/{code}")
    public void updateProductByCode(
            @PathVariable String code,
            @RequestBody UpdateProductRequest updateProductRequest
    ) {
        log.info("updateProductByCode: {}", code);
        log.info("updateProductRequest: {}", updateProductRequest);
    }

    @PatchMapping("/{code}")
    public void patchProductByCode(
            @PathVariable String code,
            @RequestBody UpdateProductRequest updateProductRequest
    ) {
        log.info("patchProductByCode: {}", code);
        log.info("patchProductRequest: {}", updateProductRequest);
    }

    @DeleteMapping("/{code}")
    public void deleteProductByCode(
            @PathVariable String code
    ) {
        log.info("Code : {}", code);
    }

}
