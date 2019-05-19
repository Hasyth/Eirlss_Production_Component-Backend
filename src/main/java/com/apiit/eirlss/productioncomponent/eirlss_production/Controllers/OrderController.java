package com.apiit.eirlss.productioncomponent.eirlss_production.Controllers;

import com.apiit.eirlss.productioncomponent.eirlss_production.Models.Order;
import com.apiit.eirlss.productioncomponent.eirlss_production.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order")
public class OrderController {


    @Autowired
    private OrderRepository orderRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Order> getOrders() {
        System.out.println("Fetching all products");
        return orderRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Order getOrder(@PathVariable String id) {
        System.out.println("Fetching product one by one");
        return orderRepository.findById(id).get();
    }

    @PostMapping(path = "/new")
    public Order newOrder(@RequestBody Order order) {

        Order neworder;


        neworder = orderRepository.save(order);
        System.out.println(neworder.getOrder_ID() + "is added ");

        return neworder;
    }

    @PutMapping
    public Order updateProduct(@RequestBody Order order) {

        return orderRepository.save(order);

    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteProduct(@PathVariable String id) {

        boolean flag;
        Order order = getOrder(id);
        if(order != null){
            orderRepository.deleteById(id);
            flag = true;
        }
        else {
            flag = false;
        }

        return flag;
    }

}
