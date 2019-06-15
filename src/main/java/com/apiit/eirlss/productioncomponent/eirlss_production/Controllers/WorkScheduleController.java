package com.apiit.eirlss.productioncomponent.eirlss_production.Controllers;

import com.apiit.eirlss.productioncomponent.eirlss_production.Models.WorkSchedule;
import com.apiit.eirlss.productioncomponent.eirlss_production.Repositories.WorkScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/workshedule")
public class WorkScheduleController {

    @Autowired
    private WorkScheduleRepository workScheduleRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<WorkSchedule> getWorkSchedules() {
        System.out.println("Fetching all products");
        return workScheduleRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public WorkSchedule getWorkSchedule(@PathVariable String id) {
        System.out.println("Fetching product one by one");
        return workScheduleRepository.findById(id).get();
    }

    @PostMapping(path = "/new")
    public WorkSchedule newWorkSchedule(@RequestBody WorkSchedule workSchedule) {

        WorkSchedule newworkschedule;

        newworkschedule = workScheduleRepository.save(workSchedule);
        System.out.println(newworkschedule.getSchedule_ID() + "is added ");

        return newworkschedule;
    }

    @PutMapping
    public WorkSchedule updateWorkSchedule(@RequestBody WorkSchedule workSchedule) {

        return workScheduleRepository.save(workSchedule);

    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteWorkSchedule(@PathVariable String id) {

        boolean flag;
        WorkSchedule workSchedule = getWorkSchedule(id);
        if(workSchedule != null){
            workScheduleRepository.deleteById(id);
            flag = true;
        }
        else {
            flag = false;
        }

        return flag;
    }

}
