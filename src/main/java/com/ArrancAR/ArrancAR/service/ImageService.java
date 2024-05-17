package com.ArrancAR.ArrancAR.service;


import com.ArrancAR.ArrancAR.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

}
