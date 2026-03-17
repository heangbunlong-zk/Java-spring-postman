package com.javaspring.a01a1webmvc.service;

import com.javaspring.a01a1webmvc.domain.Product;
import com.javaspring.a01a1webmvc.dto.ProductCreateRequest;
import com.javaspring.a01a1webmvc.dto.ProductResponse;

public interface ProductService {
    ProductResponse createNewProduct(ProductCreateRequest productCreateRequest);
}
