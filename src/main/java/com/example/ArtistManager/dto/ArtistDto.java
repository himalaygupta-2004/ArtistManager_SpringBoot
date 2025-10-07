package com.example.ArtistManager.dto;

import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtistDto {
    private Long trackId;
    private String trackName;
    private String trackComments;
    private Float trackRating;
    @ElementCollection
    private List<String> trackArtist;
}
