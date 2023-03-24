package com.ingg.ipas.controllers;

import com.ingg.ipas.models.Pass;
import com.ingg.ipas.payload.request.PassRequest;
import com.ingg.ipas.services.PassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/pass")
public class PassController {

    @Autowired
    private PassService passService;

    @GetMapping("/")
    public ResponseEntity<?> getAllPasses() {
        List<Pass> passList = passService.getAllPasses();
        if (passList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(passList, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> insertPass(@Valid @RequestBody PassRequest passRequest,@CurrentSecurityContext(expression = "authentication?.principal?.id") Long userId){
        passRequest.setUserId(userId);
        passService.insertPass(passRequest);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<?> updatePass(@Valid @RequestBody PassRequest passRequest,@CurrentSecurityContext(expression = "authentication?.principal?.id") Long userId){
        if (passRequest.getId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        passRequest.setUserId(userId);
        passService.updatePass(passRequest);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
