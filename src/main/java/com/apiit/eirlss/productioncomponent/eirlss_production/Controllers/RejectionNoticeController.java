package com.apiit.eirlss.productioncomponent.eirlss_production.Controllers;
import com.apiit.eirlss.productioncomponent.eirlss_production.Models.Product;
import com.apiit.eirlss.productioncomponent.eirlss_production.Models.RejectionNotice;
import com.apiit.eirlss.productioncomponent.eirlss_production.Repositories.RejectionNoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rejectionnotice")
public class RejectionNoticeController {

    @Autowired
    private RejectionNoticeRepository rejectionNoticeRepository;

    @GetMapping(path = "/" +
            "")
    public @ResponseBody
    Iterable<RejectionNotice> getRejectionNotices() {
        System.out.println("Fetching all products");
        return rejectionNoticeRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public RejectionNotice getRejectionNotice(@PathVariable String id) {
        System.out.println("Fetching product one by one");
        return rejectionNoticeRepository.findById(id).get();
    }

    @PostMapping(path = "/new")
    public RejectionNotice newRejectionNotice(@RequestBody RejectionNotice rejectionNotice) {

        RejectionNotice newrejectionnotice;
        newrejectionnotice = rejectionNoticeRepository.save(rejectionNotice);
        System.out.println(newrejectionnotice.getRejection_notice_ID() + "is added ");

        return newrejectionnotice;
    }

    @PutMapping
    public RejectionNotice updateRejectionNotice(@RequestBody RejectionNotice rejectionNotice) {

        return rejectionNoticeRepository.save(rejectionNotice);

    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteRejectionNotice(@PathVariable String id) {

        boolean flag;
        RejectionNotice rejectionNotice = getRejectionNotice(id);
        if(rejectionNotice != null){
            rejectionNoticeRepository.deleteById(id);
            flag = true;
        }
        else {
            flag = false;
        }

        return flag;
    }

}
