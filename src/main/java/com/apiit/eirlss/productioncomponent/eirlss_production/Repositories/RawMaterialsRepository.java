package com.apiit.eirlss.productioncomponent.eirlss_production.Repositories;

import com.apiit.eirlss.productioncomponent.eirlss_production.Models.RawMaterials;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RawMaterialsRepository extends CrudRepository<RawMaterials, String> {
}
