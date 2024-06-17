package com.ArrancAR.ArrancAR.service;

import com.ArrancAR.ArrancAR.entity.Type;
import com.ArrancAR.ArrancAR.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService {

    @Autowired
    private TypeRepository typeRepository;

    public Optional<Type> findTypeById(Long idType) { return typeRepository.findById(idType); }
    public Optional<Type> findTypeByName(String name) { return typeRepository.findByName(name); }
    public Type addType(Type brand){ return typeRepository.save(brand); }
    public List<Type> listTypes() { return typeRepository.findAll();}
    public void deleteTypeById(Long id) {
        typeRepository.deleteById(id);
    }
}
