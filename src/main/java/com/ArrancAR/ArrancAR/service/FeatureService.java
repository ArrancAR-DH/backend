package com.ArrancAR.ArrancAR.service;

import com.ArrancAR.ArrancAR.entity.Feature;
import com.ArrancAR.ArrancAR.repository.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FeatureService {

    @Autowired
    private FeatureRepository featureRepository;

    public List<Feature> listFeatures() {
        return featureRepository.findAll();
    }

    public Feature findFeatureById(Long id) {
        return featureRepository.findById(id).orElse(null);
    }

    public Feature saveFeature(Feature feature) {
        return featureRepository.save(feature);
    }

    public Feature updateFeature(Long id, Feature updatedFeature) {
        Feature existingFeature = featureRepository.findById(id).orElse(null);
        if (existingFeature != null) {
            existingFeature.setName(updatedFeature.getName());
            return featureRepository.save(existingFeature);
        }
        return null;
    }

    public void deleteFeatureById(Long id) {
        featureRepository.deleteById(id);
    }
}
