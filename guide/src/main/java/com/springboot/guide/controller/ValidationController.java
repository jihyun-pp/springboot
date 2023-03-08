package com.springboot.guide.controller;

import com.springboot.guide.data.dto.ValidRequestDto;
import com.springboot.guide.data.dto.ValidatedRequestDto;
import com.springboot.guide.data.group.ValidationGroup1;
import com.springboot.guide.data.group.ValidationGroup2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/validation")
public class ValidationController {

    private final Logger logger = LoggerFactory.getLogger(ValidationController.class);

    @PostMapping("/valid")
    public ResponseEntity<String> checkValidationByValid(@Valid @RequestBody ValidRequestDto validRequestDto){
        logger.info(validRequestDto.toString());
        return ResponseEntity.status(HttpStatus.OK).body(validRequestDto.toString());
    }

    @PostMapping("/validated")
    public ResponseEntity<String> checkValidation(@Validated @RequestBody ValidatedRequestDto validatedRequestDto){
        logger.info(validatedRequestDto.toString());
        return ResponseEntity.status(HttpStatus.OK).body(validatedRequestDto.toString());
    }

    @PostMapping("/validated/group1")
    public ResponseEntity<String> checkValidationGroup1(@Validated(ValidationGroup1.class) @RequestBody ValidatedRequestDto validatedRequestDto){
        logger.info(validatedRequestDto.toString());
        return ResponseEntity.status(HttpStatus.OK).body(validatedRequestDto.toString());
    }

    @PostMapping("/validated/group2")
    public ResponseEntity<String> checkValidationGroup2(@Validated(ValidationGroup2.class) @RequestBody ValidatedRequestDto validatedRequestDto){
        logger.info(validatedRequestDto.toString());
        return ResponseEntity.status(HttpStatus.OK).body(validatedRequestDto.toString());
    }

    @PostMapping("/validated/all-group")
    public ResponseEntity<String> checkValidation3(@Validated({ValidationGroup1.class, ValidationGroup2.class}) @RequestBody ValidatedRequestDto validatedRequestDto){
        logger.info(validatedRequestDto.toString());
        return ResponseEntity.status(HttpStatus.OK).body(validatedRequestDto.toString());
    }

}
