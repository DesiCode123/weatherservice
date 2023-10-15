package com.statnett.weatherservice.controller;

import com.statnett.weatherservice.dao.FeatureDao;
import com.statnett.weatherservice.responseentity.EarthQuakeClientResponse;
import com.statnett.weatherservice.responseentity.Feature;
import com.statnett.weatherservice.responseentity.Geometry;
import com.statnett.weatherservice.responseentity.Metadata;
import com.statnett.weatherservice.service.WeatherClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/earthquake")
public class WeatherController {
    @Autowired
    WeatherClientService weatherClientService;

    @GetMapping("/getAll")
    public EarthQuakeClientResponse getEarthquakeData() {
        return weatherClientService.getEarthquakeData();
    }

    @GetMapping("/metadataInfo")
    public Metadata getMetaDataInfo(@RequestParam String id) {
        return weatherClientService.getMetaDataInfo(id);

    }



    @GetMapping("/listOfFeatures")
    public List<FeatureDao> getListOfFeatures() {

        return weatherClientService.getListOfFeatureDao();
    }

    @GetMapping("/findById/{featureId}")
    public ResponseEntity<Object> getFeatureByID(@PathVariable String featureId) {
        try {
            FeatureDao feature = weatherClientService.getFeatureByID(featureId);

            if (feature != null) {
                return new ResponseEntity<>(feature, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Feature not found for ID: " + featureId, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            //eksempel EntityNotFoundException -id finnes ikke i databasen,IllegalArgumentException-ugyldig argument send i metoden
            return new ResponseEntity<>("Error fetching feature with ID: " + featureId + ". Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   @PostMapping("/save")
    public ResponseEntity<String> saveData(){
        try {
            weatherClientService.saveData();
            return new ResponseEntity<>("Data saved successfully",HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Error while saving data:" + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
   }
}