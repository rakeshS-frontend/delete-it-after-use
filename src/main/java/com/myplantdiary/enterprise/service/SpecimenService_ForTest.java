package com.myplantdiary.enterprise.service;

//import com.myplantdiary.enterprise.dao.IPhotoDAO;
//import com.myplantdiary.enterprise.dao.IPlantDAO;
//import com.myplantdiary.enterprise.dao.ISpecimenDAO;
//import com.myplantdiary.enterprise.dto.Photo;
//import com.myplantdiary.enterprise.dto.Plant;
//import com.myplantdiary.enterprise.dto.Specimen;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;

import com.myplantdiary.enterprise.dao.DummySpecimenDao;
import com.myplantdiary.enterprise.dto.Specimen;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@Profile("test")
public class SpecimenService_ForTest implements ISpecimenService {

    private DummySpecimenDao specimenDAO;
    @Override
    public Specimen findById(int s) {
        Specimen speimen = specimenDAO.findById(s).orElse(null);
        log.info("specicmen details - {}",speimen);
        return speimen;
    }
    @Override
    public Specimen createSpecimen(Specimen newSpecimen) {
        Specimen save = specimenDAO.save(newSpecimen);
        log.info("New Specimen saved:- {}",save);
        return save;
    }
    @Override
    public List<Specimen> findAllSpecimen() {
        List<Specimen> speimen = (List<Specimen>) specimenDAO.findAll();
        log.info("Total - {} specicmen fetched",speimen.size());
        return speimen;
    }

    @Override
    public void deleteSpecimen(int id) {
        specimenDAO.deleteById(id);
    }
}
