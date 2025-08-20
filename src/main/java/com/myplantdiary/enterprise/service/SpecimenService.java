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

import com.myplantdiary.enterprise.dao.ISpecimenDAO;
import com.myplantdiary.enterprise.dto.Specimen;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class SpecimenService implements ISpecimenService {

    private ISpecimenDAO specimenDAO;
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
