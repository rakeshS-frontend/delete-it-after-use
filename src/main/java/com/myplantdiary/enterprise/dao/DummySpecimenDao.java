package com.myplantdiary.enterprise.dao;

import com.myplantdiary.enterprise.dto.Specimen;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Profile("test")
public class DummySpecimenDao {
    public Optional<Specimen> findById(Integer id){return null;}
    public Specimen save(Specimen entity){ return null; }
    public Iterable<Specimen> findAll(){return null;}
    public void deleteById(Integer id){}

}
