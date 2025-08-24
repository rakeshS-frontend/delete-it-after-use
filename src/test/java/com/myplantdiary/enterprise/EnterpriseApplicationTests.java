package com.myplantdiary.enterprise;

//import com.myplantdiary.enterprise.dao.ISpecimenDAO;
//import com.myplantdiary.enterprise.dto.Specimen;

import com.myplantdiary.enterprise.dto.Specimen;
import com.myplantdiary.enterprise.service.ISpecimenService;
import com.myplantdiary.enterprise.service.SpecimenService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;


@SpringBootTest
@ActiveProfiles("test")
//@TestPropertySource(locations = "classpath:application-test.properties")
class EnterpriseApplicationTests {

    @MockBean
    ISpecimenService specimenService;

    @Test
    void contextLoads() {
    }

    /**
     * Given: Specimen data are available, and specimen 83 is Eastern Redbud
     * When: The user/service searches for the specimen with ID “83”
     * Then: My Plant Diary will return exactly one specimen record for "Eastern Redbud".
     */
    @Test
    void fetchSingleSpecimenByIdTest() {

        Specimen specimen = Specimen.builder().plantType("Eastern Redbud").build();
        when(specimenService.findById(83)).thenReturn(specimen);

        String plantYpe = specimen.getPlantType();
        assertEquals("Eastern Redbud", plantYpe);
    }

    /**
     * Given: Specimen data are available
     * When: The user/service posts a new Specimen object with valid attributes "latitude=39.74, longitude=-84.51"
     * Then: MyPlantDiary will create a new specimen for this record, and will return this new specimen object.
     * As a homeowner, I want to be able to upload photos of my plant at any time.
     */
    @Test
    void createSpecimenDataTest() {
        Specimen newSpecimen = Specimen.builder().plantType("Red Apple").
                latitude("39.74").longitude("-84.51").specimenId(0).build();
        Specimen savedSpecimen = Specimen.builder().plantType("Red Apple").latitude("39.74").longitude("-84.51")
                .specimenId(84).build();
        when(specimenService.createSpecimen(newSpecimen)).thenReturn(savedSpecimen);
        assertEquals(savedSpecimen.getPlantType(), newSpecimen.getPlantType());
        assertEquals(0,newSpecimen.getSpecimenId());
        assertNotEquals(0,savedSpecimen.getSpecimenId());
    }
   /** Given: Specimen data are available.
    When: The user/service searches for “kajsd;luaopuidfjo;aj;sd”
    Then: My Plant Diary will not return any results, and the user will not be able to save the specimen.
    */


}