package com.obramat.app.repository;

import com.obramat.app.domain.Order;
import com.obramat.app.domain.Product;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Id>, JpaRepository<Product, Id> {
    Product findByName(String name);
}
