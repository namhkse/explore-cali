package com.tourapp.explorecalijpa.web;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tourapp.explorecalijpa.model.TourRating;
import com.tourapp.explorecalijpa.service.TourRatingService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;




@RestController
@RequestMapping(path = "/api/tours/{tourId}/ratings")
public class TourRatingControler {
    private final TourRatingService tourRatingService;
   
    public TourRatingControler(TourRatingService tourRatingService) {
        this.tourRatingService = tourRatingService;
    }

    @GetMapping
    public List<RatingDto> lookupTourRatings(@PathVariable(value = "tourId") Integer tourId) {
        List<TourRating> tourRatings = tourRatingService.lookupRatings(tourId);
        return tourRatings.stream().map(RatingDto::new).toList();
    }

    @GetMapping("/average")
    public Map<String, Double>  getAverage(@PathVariable(value="tourId") int tourId) {
        return Map.of("average", tourRatingService.getAverageScore(tourId));
    }
    

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTourRating(@PathVariable(value = "tourId") int tourId, @RequestBody RatingDto ratingDto) {
        tourRatingService.createnew(tourId, ratingDto.getCustomerId(), ratingDto.getScore(),  ratingDto.getComment());
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String return404(NoSuchElementException exception) {
        return exception.getMessage();
    }

    @PutMapping
    public RatingDto updateWithPut(@PathVariable(name = "tourId") int tourId, @RequestBody @Valid RatingDto ratingDto) {
        return new RatingDto(tourRatingService.update(tourId, ratingDto.getCustomerId(), ratingDto.getScore(), ratingDto.getComment()));
    }

    @DeleteMapping("{customerId}")
    public void deleteRating(@PathVariable(value="tourId") int tourId, @PathVariable int customerId) {
        tourRatingService.delete(tourId, customerId);
    }

    @PatchMapping
    public RatingDto updateSome(@PathVariable(name = "tourId") int tourId, @RequestBody @Valid RatingDto ratingDto) {
        return new RatingDto(tourRatingService.updateSome(tourId, ratingDto.getCustomerId(), Optional.ofNullable(ratingDto.getScore()), Optional.ofNullable(ratingDto.getComment())));
    }

    @PostMapping("batch")
    public RatingManyResponse createRatings(@PathVariable(name = "tourId") int tourId, @RequestBody @Valid RatingManyRequest ratings) {
        return tourRatingService.rateMany(tourId, ratings.getRatings());
    }
}