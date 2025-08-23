package com.myplantdiary.enterprise;

import com.myplantdiary.enterprise.dto.Plants;
import com.myplantdiary.enterprise.dto.Specimen;
import com.myplantdiary.enterprise.retrofit.IRetrofitPlantRepository;
import com.myplantdiary.enterprise.service.ISpecimenService;
import com.myplantdiary.enterprise.service.PlantRetrofitService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.io.IOException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;


@Controller
@AllArgsConstructor
public class PlantDiaryController {

    private ISpecimenService specimenService;
    private PlantRetrofitService plantRetrofitService;

    @GetMapping("/")
    public String indexPage(Model model) {
        Specimen specimen = Specimen.builder().plantId(84).specimenId(103)
                .latitude("39.74").longitude("-84.51").description("Pawpaw fruit season").build();
//        specimen.description("Pawpaw fruit season");


        model.addAttribute(specimen);
        return "start";
    }
    @GetMapping("/specimen")
    public ResponseEntity<List<Specimen>> fetchAllSpecimen(){
        List<Specimen> specimenList = specimenService.findAllSpecimen();
        try {
            if (specimenList != null) {
                return ResponseEntity.ok(specimenList);
            } else {
                return ResponseEntity.noContent().build();
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("/specimen/{id}")
    public ResponseEntity<Specimen> fetchSpecimenById(@PathVariable("id") int id){
        Specimen sepecimen = specimenService.findById(id);
        try {
            if (sepecimen != null) {
                return ResponseEntity.ok(sepecimen);
            } else {
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping("/specimen/{id}")
    public ResponseEntity deleteSpecimenById(@PathVariable("id") int id){
        specimenService.deleteSpecimen(id);
       return ResponseEntity.noContent().build();
    }

    @PostMapping("/specimen")
    public ResponseEntity<Specimen> saveSpecimen(@RequestBody Specimen specimen) {
        Specimen newSpecimen = specimenService.createSpecimen(specimen);
        try {
            if(newSpecimen == null ||newSpecimen.getSpecimenId() ==0)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

            return ResponseEntity.ok(newSpecimen);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping(value = "/allPlants",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Plants>> fetchAllPlants() throws IOException {
       try {
           Objects.requireNonNull(plantRetrofitService,"plant retro service object null.Check Autowired");
           List<Plants> plantsList = plantRetrofitService.lookUpPlants();
           if (plantsList == null) {
               return ResponseEntity.noContent().build();
           }
           return ResponseEntity.ok(plantsList);
       }catch (Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

       }
    }

    @GetMapping(value = "/allPlants")
    public String fetchAllPlantsForm(@RequestParam(value = "searchTerm",required = false)String searchTerm, Model model) throws IOException {
        try {
            List<Plants> plantsList = plantRetrofitService.lookUpPlants();
            model.addAttribute("plants",plantsList);
            return "plants";
        }catch (Exception e){
            return "error";
        }
    }

}
