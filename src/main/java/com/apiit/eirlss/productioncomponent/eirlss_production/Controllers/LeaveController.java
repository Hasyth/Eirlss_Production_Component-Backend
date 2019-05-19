package com.apiit.eirlss.productioncomponent.eirlss_production.Controllers;


import com.apiit.eirlss.productioncomponent.eirlss_production.Models.Leave;
import com.apiit.eirlss.productioncomponent.eirlss_production.Repositories.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/leave")

public class LeaveController {

    @Autowired
    private LeaveRepository leaveRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Leave> getLeaves() {
        System.out.println("Fetching all products");
        return leaveRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Leave getLeave(@PathVariable String id) {
        System.out.println("Fetching product one by one");
        return leaveRepository.findById(id).get();
    }

    @PostMapping(path = "/new")
    public Leave newLeave(@RequestBody Leave leave) {

        Leave newleave;


        newleave = leaveRepository.save(leave);
        System.out.println(newleave.getLeave_Type() + "is added ");

        return newleave;
    }

    @PutMapping
    public Leave updateProduct(@RequestBody Leave leave) {

        return leaveRepository.save(leave);

    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteProduct(@PathVariable String id) {

        boolean flag;
        Leave leave = getLeave(id);
        if(leave != null){
            leaveRepository.deleteById(id);
            flag = true;
        }
        else {
            flag = false;
        }

        return flag;
    }



}

