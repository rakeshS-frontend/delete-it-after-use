package com.myplantdiary.enterprise.dao;

import com.myplantdiary.enterprise.dto.Specimen;
import org.springframework.data.repository.CrudRepository;

public interface ISpecimenDAO extends CrudRepository<Specimen,Integer> {

}
