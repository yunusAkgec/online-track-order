package com.example.online_track_order.Repository;

import com.example.online_track_order.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
    //Filtreleme
    //Arama
}
