package com.apiit.eirlss.productioncomponent.eirlss_production.Controllers;


import com.apiit.eirlss.productioncomponent.eirlss_production.Models.Inspection;
import com.apiit.eirlss.productioncomponent.eirlss_production.Repositories.InspectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/inspection")
public class InspectionController {

    @Autowired
    private InspectionRepository inspectionRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Inspection> getInspections() {
        System.out.println("Fetching all products");

        return inspectionRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Inspection getInspection(@PathVariable String id) {
        System.out.println("Fetching product one by one");
        return inspectionRepository.findById(id).get();
    }

    @PostMapping(path = "/new")
    public Inspection newInspection(@RequestBody Inspection inspection) {

        Inspection newinspection;


        newinspection = inspectionRepository.save(inspection);
        System.out.println(newinspection.getInspection_ID() + "is added ");

        return newinspection;
    }

    @PutMapping
    public Inspection updateProduct(@RequestBody Inspection inspection) {

        return inspectionRepository.save(inspection);

    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteProduct(@PathVariable String id) {

        boolean flag;
        Inspection inspection = getInspection(id);
        if(inspection != null){
            inspectionRepository.deleteById(id);
            flag = true;
        }
        else {
            flag = false;
        }

        return flag;
    }

}
