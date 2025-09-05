package com.tourapp.explorecalijpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tour_package")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TourPackage {
    @Id
    private String code;

    @Column
    private String name;
}
