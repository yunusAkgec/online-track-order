package com.example.online_track_order.Repository;

import com.example.online_track_order.Entity.Order;
import com.example.online_track_order.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findByUser(User user);
}
