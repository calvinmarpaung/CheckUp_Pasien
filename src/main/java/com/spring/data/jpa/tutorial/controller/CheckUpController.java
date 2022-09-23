package com.spring.data.jpa.tutorial.controller;

import com.spring.data.jpa.tutorial.entity.CheckUpRq;

import com.spring.data.jpa.tutorial.entity.Status;
import com.spring.data.jpa.tutorial.repository.CheckUpRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class CheckUpController {

    public static final Logger logger = LoggerFactory.getLogger(CheckUpController.class);
    @Autowired
    CheckUpRepo checkUpRepo;

    // -------------------Delete a Checkup-------------------------------------------
    @RequestMapping(value = "/checkup/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CheckUpRq> deleteCheckUp(@PathVariable("id") Integer id) {
        logger.info("Soft Deleting CheckUp : {}", id);
        checkUpRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // -------------------Create a Checkup-------------------------------------------
    @RequestMapping(value = "/checkup", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity createCheckUp(@RequestBody CheckUpRq checkUpRq)  {
        logger.info("Creating CheckUp : {}", checkUpRq);

        checkUpRepo.save(checkUpRq);
        return new ResponseEntity<>(checkUpRq, HttpStatus.CREATED);
    }


    // -------------------Retrieve All Patients-------------------------------------------

    @RequestMapping(value = "/checkup", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<CheckUpRq>> listAllCheckUps()  {
        List<CheckUpRq> checkUps = checkUpRepo.findAll();


        ResponseEntity responseEntity = new ResponseEntity(checkUps, HttpStatus.OK);
        return responseEntity;
    }

    // -------------------Retrieve All Patient by Status--------------------------------------------

    @RequestMapping(value = "/checkup/{status}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<CheckUpRq>> getStatusPatient(@PathVariable("status") Status status)  {
        List<CheckUpRq> checkUps = checkUpRepo.findByStatus(status);

        ResponseEntity responseEntity = new ResponseEntity(checkUps, HttpStatus.OK);
        return responseEntity;
    }

   // ------------------- Update Status Patient by Id ------------------------------------------------

    @RequestMapping(value = "/checkup/{id}/update-status", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePatient(@PathVariable("id") Integer id, @RequestBody CheckUpRq checkUpRq)  {
        logger.info("Updating Status Patient with id {}", id);

        CheckUpRq currentCheckup = checkUpRepo.findPatientById(id);
        currentCheckup.setStatus(checkUpRq.getStatus());
        checkUpRepo.update(currentCheckup);
        return new ResponseEntity<>(currentCheckup, HttpStatus.OK);
    }

}



