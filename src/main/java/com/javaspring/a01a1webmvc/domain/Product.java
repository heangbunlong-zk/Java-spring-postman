package com.javaspring.a01a1webmvc.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    private String code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Boolean status;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<OrderLine> orderLines;
}
