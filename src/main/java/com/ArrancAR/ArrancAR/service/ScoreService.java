package com.ArrancAR.ArrancAR.service;

import com.ArrancAR.ArrancAR.entity.Score;
import com.ArrancAR.ArrancAR.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    @Autowired
    ScoreRepository scoreRepository;

    public Score saveScore(Score score){return scoreRepository.save(score);}
}
