package com.example.ArtistManager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;


@Getter
@Setter
@Entity
public class ArtistEntity {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long trackId;
    private String trackName;
    private String trackComments;
    private Float trackRating;
    private ArrayList<String> trackArtist;

}
