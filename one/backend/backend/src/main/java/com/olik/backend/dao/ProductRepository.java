package com.olik.backend.dao;

import com.olik.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {


    @Query(value = "INSERT INTO Product (name, price, availableFromDateTime, availableToDateTime) VALUES (:name, :price, :availableFromDateTime, :availableToDateTime)", nativeQuery = true)
    Product saveProduct(
            @Param("name") String name,
            @Param("pricePerHour") double price,
            @Param("availableFromDateTime") LocalDateTime availableFromDateTime,
            @Param("availableToDateTime") LocalDateTime availableToDateTime
    );


    @Query("SELECT p FROM Product p WHERE p.availableFromDateTime >= :startDate AND p.availableToDateTime <= :endDate")
    List<Product> findAvailableProductsBetweenDates(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);



}
