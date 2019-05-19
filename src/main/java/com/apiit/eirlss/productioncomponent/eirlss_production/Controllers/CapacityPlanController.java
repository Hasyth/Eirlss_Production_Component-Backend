package com.apiit.eirlss.productioncomponent.eirlss_production.Controllers;

import com.apiit.eirlss.productioncomponent.eirlss_production.Models.CapacityPlan;
import com.apiit.eirlss.productioncomponent.eirlss_production.Repositories.CapacityPlanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/capacityplan")
public class CapacityPlanController {

    @Autowired
    private CapacityPlanRepository capacityPlanRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<CapacityPlan> getCapacityPlans() {
        System.out.println("Fetching all products");
        return capacityPlanRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public CapacityPlan getCapacityPlan(@PathVariable String id) {
        System.out.println("Fetching product one by one");
        return capacityPlanRepository.findById(id).get();
    }

    @PostMapping(path = "/new")
    public CapacityPlan newCapacityPlan(@RequestBody CapacityPlan capacityPlan) {

        CapacityPlan newcapacityplan;


        newcapacityplan = capacityPlanRepository.save(capacityPlan);
        System.out.println(newcapacityplan.getPlan_ID() + "is added ");

        return newcapacityplan;
    }

    @PutMapping
    public CapacityPlan updateProduct(@RequestBody CapacityPlan capacityPlan) {

        return capacityPlanRepository.save(capacityPlan);

    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteProduct(@PathVariable String id) {

        boolean flag;
        CapacityPlan capacityPlan = getCapacityPlan(id);
        if(capacityPlan != null){
            capacityPlanRepository.deleteById(id);
            flag = true;
        }
        else {
            flag = false;
        }

        return flag;
    }


}
