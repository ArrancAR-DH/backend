package com.ArrancAR.ArrancAR.service;


import com.ArrancAR.ArrancAR.entity.Image;
import com.ArrancAR.ArrancAR.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public Image addImage(Image image) {
        return imageRepository.save(image);
    }

    public Optional<Image> findImageById(Long id) {
        return imageRepository.findById(id);
    }
}
