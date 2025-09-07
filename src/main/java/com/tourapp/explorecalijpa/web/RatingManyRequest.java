package com.tourapp.explorecalijpa.web;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RatingManyRequest {
    @NotNull
    @NotEmpty
    private List<RatingDto> ratings;
}
