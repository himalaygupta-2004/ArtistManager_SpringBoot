package com.example.ArtistManager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewArtisstDto {
    private String trackName;
    private String trackComments;
    private Float trackRating;
    private ArrayList<String> trackArtist;
}
