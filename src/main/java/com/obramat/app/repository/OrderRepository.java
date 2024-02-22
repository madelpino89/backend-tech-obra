package com.obramat.app.repository;

import com.obramat.app.domain.Order;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepository extends CrudRepository<Order, Id>, JpaRepository<Order, Id> {

}
