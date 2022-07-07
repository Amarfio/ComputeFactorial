package com.example.ComputeFactorial.controller;

import com.example.ComputeFactorial.exception.ResourceNotFoundException;
import com.example.ComputeFactorial.model.Factorial;
import com.example.ComputeFactorial.repository.FactorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/FactorialCalculator/api/v1")
public class FactorialController {
    @Autowired
    private FactorialRepository factorialRepository;

    //get factorials : get all factorials saved in the database
    @GetMapping("/factorials")
    public List<Factorial> getAllFactorials(){
        return this.factorialRepository.findAll();
    }

    //get factorial specified by id: get a particular factorial details specified by id
    @GetMapping("/factorials/{id}")
    public ResponseEntity<Factorial> getFactorialById(@PathVariable(value="id") Long factorialId) throws ResourceNotFoundException {
        Factorial factorial = factorialRepository.findById(factorialId).orElseThrow(()-> new ResourceNotFoundException("Factorial details not found for this id::"+ factorialId));
        return ResponseEntity.ok().body(factorial);
    }

    //save factorial: post new factorial details
    @PostMapping("/factorials")
    public Factorial createFactorial(@RequestBody Factorial factorial){
        long outCome = factorial.computeFactorial(factorial.getFigure());
        factorial.setOutcome(outCome);
        return this.factorialRepository.save(factorial);
    }

    //update figure: post to edit factorial details by a specified id
    @PutMapping("/factorials/{id}")
    public ResponseEntity updateEmployee(@PathVariable(value="id") Long factorialId, @Validated @RequestBody Factorial factorialDetails) throws ResourceNotFoundException{
        Factorial factorial = factorialRepository.findById(factorialId).orElseThrow(()-> new ResourceNotFoundException("Factorail not found for this id::"+ factorialId));
        factorial.setFigure(factorialDetails.getFigure());
        
        //code to calculate and store the outcome using the factorial details
        factorial.setOutcome(factorial.computeFactorial(factorialDetails.getFigure()));
        return ResponseEntity.ok(this.factorialRepository.save(factorial));
    }
}
