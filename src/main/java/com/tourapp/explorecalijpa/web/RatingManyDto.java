package com.tourapp.explorecalijpa.web;

import java.util.List;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RatingManyDto {
    @Min(0)
    @Max(5)
    private int score;

    @NotNull
    @NotEmpty
    private List<Integer> customerIds;
}
