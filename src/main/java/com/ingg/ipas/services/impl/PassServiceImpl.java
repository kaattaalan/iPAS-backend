package com.ingg.ipas.services.impl;

import com.ingg.ipas.models.Pass;
import com.ingg.ipas.payload.request.PassRequest;
import com.ingg.ipas.repository.PassRepo;
import com.ingg.ipas.services.PassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service("passServiceImpl")
public class PassServiceImpl implements PassService {

    @Autowired
    private PassRepo passRepo;

    @Override
    public List<Pass> getAllPasses() {
        return passRepo.findAll();
    }

    @Override
    public void insertPass(PassRequest passRequest) {
        Pass pass = new Pass();
        pass.setName(passRequest.getPassName());
        passRepo.save(pass);

    }

    @Override
    public void updatePass(PassRequest passRequest) {
        Optional<Pass> optionalPass = passRepo.findById(passRequest.getId());
        if (optionalPass.isPresent()) {
            Pass pass = optionalPass.get();
            pass.setName(passRequest.getPassName());
            passRepo.save(pass);
        } else {
            throw new EntityNotFoundException("Pass not found with id: " + passRequest.getId());
        }
    }
}
