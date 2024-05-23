package com.ArrancAR.ArrancAR.service;


import com.ArrancAR.ArrancAR.entity.Model;
import com.ArrancAR.ArrancAR.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelService {
    
    @Autowired
    private ModelRepository modelRepository;

    public Optional<Model> findModelById(Long idModel) {
        return modelRepository.findById(idModel);
    }
    public Optional<Model> findModelByName(String name) {
        return modelRepository.findByName(name);
    }
    public Model addModel(Model brand){
        return modelRepository.save(brand);
    }
    public List<Model> listModels() {
        return modelRepository.findAll();
    }
}
