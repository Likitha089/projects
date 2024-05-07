package com.likitha.loggingapp.Repository;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.likitha.loggingapp.Model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel,UUID> {
    
}
