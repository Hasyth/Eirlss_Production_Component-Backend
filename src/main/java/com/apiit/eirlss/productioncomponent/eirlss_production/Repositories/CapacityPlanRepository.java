package com.apiit.eirlss.productioncomponent.eirlss_production.Repositories;


import com.apiit.eirlss.productioncomponent.eirlss_production.Models.CapacityPlan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapacityPlanRepository extends CrudRepository<CapacityPlan, String> {
}
