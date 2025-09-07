package com.tourapp.explorecalijpa.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourapp.explorecalijpa.model.TourRating;

public interface TourRatingRepository extends JpaRepository<TourRating, Integer> {
    /**
     * Lookup all the tour ratings for a tour.
     * @param tourId
     * @return
     */
    List<TourRating> findByTourId(Integer tourId);

    /**
     * Lookup a tour ratting by the tour id and customer id.
     * @param tourId
     * @param customerId
     * @return
     */
    Optional<TourRating> findByTourIdAndCustomerId(Integer tourId, Integer customerId);    
}
    
