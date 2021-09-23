package com.example.restservice.controllers;

import com.example.restservice.dao.OrderDao;
import com.example.restservice.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderDao orderDao;

    @RequestMapping(value = "api/orders/{id}", method = RequestMethod.GET)
    public Order getOrder(@PathVariable int id) {
        return orderDao.getOrder(id);
    }

    @RequestMapping(value = "api/orders", method = RequestMethod.GET)
    public List<Order> getOrders(){
        return orderDao.getOrders();
    }

    @RequestMapping(value = "api/orders", method = RequestMethod.POST)
    public void createOrder(@RequestBody Order order){
        orderDao.createOrder(order);
    }

    @RequestMapping(value = "api/orders/{id}", method = RequestMethod.DELETE)
    public void deleteOrder(@PathVariable int id){
        orderDao.deleteOrder(id);
    }

    @RequestMapping(value = "api/orders", method = RequestMethod.PUT)
    public void updateOrder(@RequestBody Order order){

    }

}