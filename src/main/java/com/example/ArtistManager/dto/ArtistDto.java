package com.example.ArtistManager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtistDto {
    private Long trackId;
    private String trackName;
    private String trackComments;
    private Float trackRating;
    private ArrayList<String> trackArtist;
}
