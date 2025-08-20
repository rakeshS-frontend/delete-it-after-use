package com.myplantdiary.enterprise.service;

//import com.myplantdiary.enterprise.dto.Photo;
//import com.myplantdiary.enterprise.dto.Plant;
//import com.myplantdiary.enterprise.dto.Specimen;
import com.myplantdiary.enterprise.dto.Specimen;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ISpecimenService {

    Specimen findById(int s);

    Specimen createSpecimen(Specimen newSpecimen);

    List<Specimen> findAllSpecimen();
    void deleteSpecimen(int id);

}
