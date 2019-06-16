package com.apiit.eirlss.productioncomponent.eirlss_production.Controllers;


import com.apiit.eirlss.productioncomponent.eirlss_production.Models.BillOfMaterials;
import com.apiit.eirlss.productioncomponent.eirlss_production.Repositories.BillOfMaterialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/billofmaterials")
public class BillOfMaterialsController {

    @Autowired
    private BillOfMaterialsRepository billOfMaterialsRepository;


    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<BillOfMaterials> getBills() {
        System.out.println("Fetching all products");
        return billOfMaterialsRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public BillOfMaterials getBill(@PathVariable String id) {
        System.out.println("Fetching product one by one");
        return billOfMaterialsRepository.findById(id).get();
    }

    @PostMapping(path = "/new")
    public BillOfMaterials newBill(@RequestBody BillOfMaterials billOfMaterials) {

        BillOfMaterials newbill;


        newbill = billOfMaterialsRepository.save(billOfMaterials);
        System.out.println(newbill.getBom_ID() + "is added ");

        return newbill;
    }

    @PutMapping
    public BillOfMaterials updateBill(@RequestBody BillOfMaterials billOfMaterials) {

        return billOfMaterialsRepository.save(billOfMaterials);

    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteBill(@PathVariable String id) {

        boolean flag;
        BillOfMaterials product = getBill(id);
        if(product != null){
            billOfMaterialsRepository.deleteById(id);
            flag = true;
        }
        else {
            flag = false;
        }

        return flag;
    }


}
