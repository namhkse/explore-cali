package com.tourapp.explorecalijpa.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourapp.explorecalijpa.model.TourPackage;

public interface TourPackageRepository extends JpaRepository<TourPackage, String> {
    public Optional<TourPackage> findByName(String name);
}
