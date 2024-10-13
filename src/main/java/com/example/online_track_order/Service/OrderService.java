package com.example.online_track_order.Service;

import com.example.online_track_order.Entity.Order;
import com.example.online_track_order.Entity.Product;
import com.example.online_track_order.Entity.User;
import com.example.online_track_order.Enum.OrderStatus;
import com.example.online_track_order.Repository.OrderRepository;
import com.example.online_track_order.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    public Order createOrder(User user, List<Product> products){
        Order order = new Order();
        order.setUser(user);
        order.setProducts(products);
        order.setStatus(OrderStatus.PENDING);
        order.setOrderDate(LocalDateTime.now());
        return orderRepository.save(order);
    }

    public Order getOrderById(Long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        return order.orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order updateOrderStatus(Long orderId, OrderStatus status){
        Order order = getOrderById(orderId);
        order.setStatus(status);
        return orderRepository.save(order);
    }

    public Order cancelOrder(Long orderId){
        Order order = getOrderById(orderId);
        if (order.getStatus() != OrderStatus.PENDING){
            throw new IllegalStateException("Only pending orders can be canceled");
        }

        order.setStatus(OrderStatus.CANCELLED);
        return orderRepository.save(order);
    }
}
