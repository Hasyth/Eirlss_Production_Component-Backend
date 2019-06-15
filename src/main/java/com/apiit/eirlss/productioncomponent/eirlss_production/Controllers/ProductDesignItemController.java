package com.apiit.eirlss.productioncomponent.eirlss_production.Controllers;


import com.apiit.eirlss.productioncomponent.eirlss_production.Models.ProductDesignItem;
import com.apiit.eirlss.productioncomponent.eirlss_production.Repositories.ProductDesignItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product-design-item")
public class   ProductDesignItemController {

    @Autowired
    private ProductDesignItemRepository productDesignItemRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<ProductDesignItem> getProductDesignItems() {
        System.out.println("Fetching all products");
        return productDesignItemRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ProductDesignItem getProductDesignItem(@PathVariable String id) {
        System.out.println("Fetching product one by one");
        return productDesignItemRepository.findById(id).get();
    }

    @PostMapping(path = "/new")
    public ProductDesignItem newProductDesignItem(@RequestBody ProductDesignItem productDesignItem) {

        ProductDesignItem newproductdesignitem;


        newproductdesignitem = productDesignItemRepository.save(productDesignItem);
        System.out.println(newproductdesignitem.getProductDesignItem_ID()
                + "is added ");

        return newproductdesignitem;
    }

    @PutMapping
    public ProductDesignItem updateProductDesignItem(@RequestBody ProductDesignItem productDesignItem) {

        return productDesignItemRepository.save(productDesignItem);

    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteProductDesignItem(@PathVariable String id) {

        boolean flag;
        ProductDesignItem product = getProductDesignItem(id);
        if(product != null){
            productDesignItemRepository.deleteById(id);
            flag = true;
        }
        else {
            flag = false;
        }

        return flag;
    }

}

