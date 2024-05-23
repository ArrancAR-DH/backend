package com.ArrancAR.ArrancAR.service;

import com.ArrancAR.ArrancAR.entity.Brand;
import com.ArrancAR.ArrancAR.entity.Vehicle;
import com.ArrancAR.ArrancAR.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public Optional<Brand> findBrandById(Long idBrand) { return brandRepository.findById(idBrand); }
    public Optional<Brand> findBrandByName(String name) { return brandRepository.findByName(name); }
    public Brand addBrand(Brand brand){ return brandRepository.save(brand); }
    public List<Brand> listBrands() { return brandRepository.findAll();}



}
