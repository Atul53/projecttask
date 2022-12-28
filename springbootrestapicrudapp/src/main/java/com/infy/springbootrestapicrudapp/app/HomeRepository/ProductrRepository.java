package com.infy.springbootrestapicrudapp.app.HomeRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.infy.springbootrestapicrudapp.app.Model.ProductEntity;

public interface ProductrRepository extends JpaRepository<ProductEntity, Integer> {

}
