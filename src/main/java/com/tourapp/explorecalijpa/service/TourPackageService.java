package com.tourapp.explorecalijpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tourapp.explorecalijpa.model.TourPackage;
import com.tourapp.explorecalijpa.repo.TourPackageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TourPackageService {
    private final TourPackageRepository packageRepository;

    public TourPackage createTourPackage(String code, String name) {
        return packageRepository.findById(code).orElse(packageRepository.save(new TourPackage(code, name)));
    }

    public List<TourPackage> lookupAll() {
        return packageRepository.findAll();
    }

    public long total() {
        return packageRepository.count();
    }

}
