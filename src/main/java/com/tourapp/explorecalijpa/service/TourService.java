package com.tourapp.explorecalijpa.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.tourapp.explorecalijpa.model.Difficulty;
import com.tourapp.explorecalijpa.model.Region;
import com.tourapp.explorecalijpa.model.Tour;
import com.tourapp.explorecalijpa.model.TourPackage;
import com.tourapp.explorecalijpa.repo.TourPackageRepository;
import com.tourapp.explorecalijpa.repo.TourRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TourService {

    private final TourRepository tourRepository;
    private final TourPackageRepository packageRepository;

    public Tour createTour(
            String tourPackageName,
            String title,
            String description,
            String blurb,
            Integer price,
            String duration,
            String bullets,
            String keywords,
            Difficulty difficulty,
            Region region) {
        TourPackage tourPackage = packageRepository.findByName(tourPackageName)
            .orElseThrow(() -> new RuntimeException("Tour package not found ofr id" + tourPackageName));

        var tour = Tour.builder().title(title).description(description).blurb(blurb).price(price)
                .duration(duration).bullets(bullets).keywords(keywords).tourPackage(tourPackage).difficulty(difficulty)
                .region(region)
                .build();
        
        return tourRepository.save(tour);
    }

    public long total() {
        return tourRepository.count();
    }

    public List<Tour> lookupByDifficulty(Difficulty difficulty) {
        return tourRepository.findByDifficulty(difficulty);
    }

    public List<Tour> lookupByPackage(String code) {
        return tourRepository.findByTourPackageCode(code);
    }
}
