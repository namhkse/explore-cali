package com.tourapp.explorecalijpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourapp.explorecalijpa.model.Difficulty;
import com.tourapp.explorecalijpa.model.Tour;

public interface TourRepository extends JpaRepository<Tour, Integer> {

    List<Tour> findByDifficulty(Difficulty difficulty);

    List<Tour> findByTourPackageCode(String code);

}
