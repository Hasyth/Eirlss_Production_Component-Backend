package com.apiit.eirlss.productioncomponent.eirlss_production.Controllers;


import com.apiit.eirlss.productioncomponent.eirlss_production.Models.BillItem;
import com.apiit.eirlss.productioncomponent.eirlss_production.Repositories.BillItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value= "/billitem")
public class BillItemController {

    @Autowired
    private BillItemRepository billItemRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<BillItem> getBillItems() {
        System.out.println("Fetching all products");
        return billItemRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public BillItem getBillItem(@PathVariable String id) {
        System.out.println("Fetching product one by one");
        return billItemRepository.findById(id).get();
    }

    @PostMapping(path = "/new")
    public BillItem newBillItem(@RequestBody BillItem billItem) {

        BillItem newbillitem;


        newbillitem = billItemRepository.save(billItem);
        System.out.println(newbillitem.getBillitem_ID() + "is added ");

        return newbillitem;
    }

    @PutMapping
    public BillItem updateBillItem(@RequestBody BillItem billItem) {

        return billItemRepository.save(billItem);

    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteBillItem(@PathVariable String id) {

        boolean flag;
        BillItem billItem = getBillItem(id);
        if(billItem != null){
            billItemRepository.deleteById(id);
            flag = true;
        }
        else {
            flag = false;
        }

        return flag;
    }


}
