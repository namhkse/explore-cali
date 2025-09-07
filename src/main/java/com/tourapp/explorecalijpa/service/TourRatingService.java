package com.tourapp.explorecalijpa.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalDouble;

import org.springframework.stereotype.Service;

import com.tourapp.explorecalijpa.model.Tour;
import com.tourapp.explorecalijpa.model.TourRating;
import com.tourapp.explorecalijpa.repo.TourRatingRepository;
import com.tourapp.explorecalijpa.repo.TourRepository;

@Service
public class TourRatingService {
    private final TourRatingRepository tourRatingRepository;
    private final TourRepository tourRepository;

    public TourRatingService(TourRatingRepository ratingRepository, TourRepository tourRepository) {
        this.tourRatingRepository = ratingRepository;
        this.tourRepository = tourRepository;
    }

    /**
     * Create a new tour rating.
     * 
     * @param tourId
     * @param customerId
     * @param score
     * @param comment
     * @return
     */
    public TourRating createnew(int tourId, int customerId, Integer score, String comment) {
        Tour tour = verifyTour(tourId);
        return tourRatingRepository.save(new TourRating(tour, customerId, score, comment));
    }

    /**
     * Get a page of tour ratings for a tour.
     * @param tourId
     * @return
     */
    public List<TourRating> lookupRatings(Integer tourId) {
        tourId = verifyTour(tourId).getId();
        return tourRatingRepository.findByTourId(tourId);
    }

    /**
     * Verify and return the tour given a tour id.
     * 
     * @param tourId
     * @return
     * @throws NoSuchElementException
     */
    private Tour verifyTour(int tourId) throws NoSuchElementException {
        return tourRepository.findById(tourId)
                .orElseThrow(() -> new NoSuchElementException("Tour does not exist " + tourId));
    }

    public TourRating update(int tourId, Integer customerId, Integer score, String comment) {
        TourRating rating = verifyTourRating(tourId, customerId);
        rating.setScore(score);
        rating.setComment(comment);
        return tourRatingRepository.save(rating);
    }

    public TourRating verifyTourRating(int tourId, int customerId) throws NoSuchElementException {
        return tourRatingRepository.findByTourIdAndCustomerId(tourId, customerId)
                .orElseThrow(() -> new NoSuchElementException("Tour-Rating pair for request("
                        + tourId + " for customer" + customerId));
    }

    /**
     * Update some of the elements of a tour rating.
     * @param tourId
     * @param customerId
     * @param score
     * @param comment
     * @return
     */
    public TourRating updateSome(int tourId, Integer customerId, Optional<Integer> score, Optional<String> comment) {
        TourRating rating = verifyTourRating(tourId, customerId);
        score.ifPresent(s -> rating.setScore(s));
        comment.ifPresent(c -> rating.setComment(c));
        return tourRatingRepository.save(rating);
    }

    /**
     * Get a rating by id.
     * @param id
     * @return
     */
    public Optional<TourRating> lookupRatingId(int id) {
        return tourRatingRepository.findById(id);
    }

    /**
     * Get all ratings.
     * @return
     */
    public List<TourRating> lookupAll() {
        return tourRatingRepository.findAll();
    }

    /**
     * Update all of the elements of a tour rating.
     * @param tourId
     * @param customerId
     * @param score
     * @param comment
     * @return
     */
    public TourRating update(int tourId, int customerId, Integer score, String comment) {
        TourRating rating = verifyTourRating(tourId, customerId);
        rating.setScore(score);
        rating.setComment(comment);
        return tourRatingRepository.save(rating);
    }

    /**
     * Delete a rating.
     * @param tourId
     * @param customerId
     */
    public void delete(int tourId, int customerId) {
        TourRating rating = verifyTourRating(tourId, customerId);
        tourRatingRepository.delete(rating);
    }

    /**
     * Get the avg score of tour.
     * @param tourId
     * @return
     */
    public Double getAverageScore(int tourId) {
        List<TourRating> ratings = tourRatingRepository.findByTourId(tourId);
        OptionalDouble avg = ratings.stream().mapToInt(r -> r.getScore()).average();
        return avg.isPresent() ? avg.getAsDouble() : 0;
    }
}
