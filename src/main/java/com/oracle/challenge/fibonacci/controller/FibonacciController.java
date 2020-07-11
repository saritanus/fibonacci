package com.oracle.challenge.fibonacci.controller;

import com.oracle.challenge.fibonacci.exception.InvalidInputException;
import com.oracle.challenge.fibonacci.model.FibonacciRequest;
import com.oracle.challenge.fibonacci.model.FibonacciResponse;
import com.oracle.challenge.fibonacci.service.FibonacciService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/fibonacci")
public class FibonacciController {
    @PostMapping
    public ResponseEntity<?>  generateSeries(@RequestBody FibonacciRequest request){
        FibonacciResponse result = new FibonacciResponse();
        try {
            result = FibonacciService.getFibonacciSequence(request.getElements());
            return new ResponseEntity<>(result,HttpStatus.OK);
        }catch (InvalidInputException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
}
