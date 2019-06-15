package com.apiit.eirlss.productioncomponent.eirlss_production.Controllers;


import com.apiit.eirlss.productioncomponent.eirlss_production.Models.LeaveType;
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
    Iterable<LeaveType> getLeaves() {
        System.out.println("Fetching all products");
        return leaveRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public LeaveType getLeave(@PathVariable String id) {
        System.out.println("Fetching product one by one");
        return leaveRepository.findById(id).get();
    }

    @PostMapping(path = "/new")
    public LeaveType newLeave(@RequestBody LeaveType leaveType) {

        LeaveType newleave;


        newleave = leaveRepository.save(leaveType);
        System.out.println(newleave.getLeave_Type() + "is added ");

        return newleave;
    }

    @PutMapping
    public LeaveType updateProduct(@RequestBody LeaveType leaveType) {

        return leaveRepository.save(leaveType);

    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteProduct(@PathVariable String id) {

        boolean flag;
        LeaveType leaveType = getLeave(id);
        if(leaveType != null){
            leaveRepository.deleteById(id);
            flag = true;
        }
        else {
            flag = false;
        }

        return flag;
    }



}

