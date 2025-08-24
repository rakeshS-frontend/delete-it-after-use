package com.myplantdiary.enterprise.dao;

import com.myplantdiary.enterprise.dto.Specimen;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
@Profile("dev")
public interface ISpecimenDAO extends CrudRepository<Specimen,Integer> {

}
