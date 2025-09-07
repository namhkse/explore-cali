package com.tourapp.explorecalijpa.web;

import com.tourapp.explorecalijpa.model.TourRating;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class RatingDto {

    @Min(0)
    @Max(5)
    private Integer score; 

    @Size(max = 255)
    private String comment;

    @NotNull
    private Integer customerId;

    public RatingDto() {
    }

    public RatingDto(TourRating rating) {
        score = rating.getScore();
        customerId = rating.getCustomerId();
        comment = rating.getComment();
    }
}