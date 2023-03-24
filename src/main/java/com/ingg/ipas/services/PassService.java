package com.ingg.ipas.services;

import com.ingg.ipas.models.Pass;
import com.ingg.ipas.payload.request.PassRequest;

import java.util.List;

public interface PassService {

    List<Pass> getAllPasses();

    void insertPass(PassRequest passRequest);

    void updatePass(PassRequest passRequest);


}
