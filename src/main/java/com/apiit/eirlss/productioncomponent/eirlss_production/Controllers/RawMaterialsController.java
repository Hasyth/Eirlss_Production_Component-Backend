package com.apiit.eirlss.productioncomponent.eirlss_production.Controllers;

import com.apiit.eirlss.productioncomponent.eirlss_production.Models.Product;
import com.apiit.eirlss.productioncomponent.eirlss_production.Models.RawMaterials;
import com.apiit.eirlss.productioncomponent.eirlss_production.Repositories.RawMaterialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = "/rawmaterials")
public class RawMaterialsController {

    @Autowired
    private RawMaterialsRepository rawMaterialsRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<RawMaterials> getRawMaterials() {
        System.out.println("Fetching all products");
        return rawMaterialsRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public RawMaterials getRawMaterial(@PathVariable String id) {
        System.out.println("Fetching product one by one");
        return rawMaterialsRepository.findById(id).get();
    }

    @PostMapping(path = "/new")
    public RawMaterials newProduct(@RequestBody RawMaterials rawMaterials) {

        RawMaterials newproduct;


        newproduct = rawMaterialsRepository.save(rawMaterials);
        System.out.println(newproduct.getMaterial_ID() + "is added ");

        return newproduct;
    }

    @PutMapping
    public RawMaterials updateProduct(@RequestBody RawMaterials rawMaterials) {

        return rawMaterialsRepository.save(rawMaterials);

    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteProduct(@PathVariable String id) {

        boolean flag;
        RawMaterials rawMaterial = getRawMaterial(id);
        if(rawMaterial != null){
            rawMaterialsRepository.deleteById(id);
            flag = true;
        }
        else {
            flag = false;
        }

        return flag;
    }

}
