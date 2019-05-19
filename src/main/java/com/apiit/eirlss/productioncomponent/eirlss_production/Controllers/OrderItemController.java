package com.apiit.eirlss.productioncomponent.eirlss_production.Controllers;


import com.apiit.eirlss.productioncomponent.eirlss_production.Models.OrderItem;
import com.apiit.eirlss.productioncomponent.eirlss_production.Repositories.OrderItemRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/orderitem")
public class OrderItemController {


    @Autowired
    private OrderItemRepository orderItemRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<OrderItem> getOrderItems() {
        System.out.println("Fetching all products");
        return orderItemRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public OrderItem getOrderItem(@PathVariable String id) {
        System.out.println("Fetching product one by one");
        return orderItemRepository.findById(id).get();
    }

    @PostMapping(path = "/new")
    public OrderItem newOrderItem(@RequestBody OrderItem orderItem) {

        OrderItem neworderitem;


        neworderitem = orderItemRepository.save(orderItem);
        System.out.println(neworderitem.getOrderitem_ID() + "is added ");

        return neworderitem;
    }

    @PutMapping
    public OrderItem updateProduct(@RequestBody OrderItem orderItem) {

        return orderItemRepository.save(orderItem);

    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteProduct(@PathVariable String id) {

        boolean flag;
        OrderItem product = getOrderItem(id);
        if(product != null){
            orderItemRepository.deleteById(id);
            flag = true;
        }
        else {
            flag = false;
        }

        return flag;
    }

}
