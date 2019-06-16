package com.apiit.eirlss.productioncomponent.eirlss_production.Controllers;

import com.apiit.eirlss.productioncomponent.eirlss_production.Models.SalesOrder;
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
    Iterable<SalesOrder> getOrders() {
        System.out.println("Fetching all products");
        return orderRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public SalesOrder getOrder(@PathVariable String id) {
        System.out.println("Fetching product one by one");
        return orderRepository.findById(id).get();
    }

    @PostMapping(path = "/new")
    public SalesOrder newOrder(@RequestBody SalesOrder salesOrder) {

        SalesOrder neworder;


        neworder = orderRepository.save(salesOrder);
        System.out.println(neworder.getOrderId() + "is added ");

        return neworder;
    }

    @PutMapping
    public SalesOrder updateProduct(@RequestBody SalesOrder salesOrder) {

        return orderRepository.save(salesOrder);

    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteProduct(@PathVariable String id) {

        boolean flag;
        SalesOrder salesOrder = getOrder(id);
        if(salesOrder != null){
            orderRepository.deleteById(id);
            flag = true;
        }
        else {
            flag = false;
        }

        return flag;
    }

}
