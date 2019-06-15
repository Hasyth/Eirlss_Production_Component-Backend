package com.apiit.eirlss.productioncomponent.eirlss_production.Controllers;


import com.apiit.eirlss.productioncomponent.eirlss_production.Models.ProductDesign;
import com.apiit.eirlss.productioncomponent.eirlss_production.Repositories.ProductDesignRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product-design")
public class   ProductDesignController {

    @Autowired
    private ProductDesignRepositroy productDesignRepositroy;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<ProductDesign> getProductDesigns() {
        System.out.println("Fetching all products");
        return productDesignRepositroy.findAll();
    }

    @GetMapping(path = "/{id}")
    public ProductDesign getProductDesign(@PathVariable String id) {
        System.out.println("Fetching product one by one");
        return productDesignRepositroy.findById(id).get();
    }

    @PostMapping(path = "/new")
    public ProductDesign newProductDesign(@RequestBody ProductDesign productDesign) {

        ProductDesign newproductdesign;


        newproductdesign = productDesignRepositroy.save(productDesign);
        System.out.println(newproductdesign.getDesign_ID() + "is added ");

        return newproductdesign;
    }

    @PutMapping
    public ProductDesign updateProductDesign(@RequestBody ProductDesign productDesign) {

        return productDesignRepositroy.save(productDesign);

    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteProductDesign(@PathVariable String id) {

        boolean flag;
        ProductDesign product = getProductDesign(id);
        if(product != null){
            productDesignRepositroy.deleteById(id);
            flag = true;
        }
        else {
            flag = false;
        }

        return flag;
    }

}

