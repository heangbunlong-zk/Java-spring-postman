package com.javaspring.a01a1webmvc.service;

import com.javaspring.a01a1webmvc.domain.Category;
import com.javaspring.a01a1webmvc.domain.Product;
import com.javaspring.a01a1webmvc.dto.ProductCreateRequest;
import com.javaspring.a01a1webmvc.dto.ProductResponse;
import com.javaspring.a01a1webmvc.repository.CategoryRepository;
import com.javaspring.a01a1webmvc.repository.ProductRepository;
import com.javaspring.a01a1webmvc.util.GenerateUtill;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
// seervice hav productRepo and CategoryRepo
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public ProductResponse createNewProduct(ProductCreateRequest productCreateRequest) {

        // TODO : write logic to create a new  product
        // 1. validate category ID (Exist or not)
        Category category = categoryRepository
                .findById(productCreateRequest.categoryId())
                .orElseThrow(() -> new RuntimeException("Category Id does not exsit"));
        log.info("category: {} ", category.getId());

        // 2. Transfer data from Dto to entity
        Product product = new Product();
        product.setCategory(category);
        product.setName(productCreateRequest.name());
        product.setPrice(productCreateRequest.price());

        //3 set system data
        product.setStatus(true);
        product.setCode(GenerateUtill.generateProductCode());

        //4. sava data into databass
        product = productRepository.save(product);

        //5. tansfer data from Entity to DTO
        return ProductResponse.builder()
                .code(product.getCode())
                .name(product.getName())
                .price(product.getPrice())
                .status(product.getStatus())
                .categoryName(product.getCategory().getName())
                .build();


    }
}
