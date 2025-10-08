package com.example.ArtistManager.service;

import com.example.ArtistManager.dto.ArtistDto;
import com.example.ArtistManager.dto.NewArtisstDto;
import com.example.ArtistManager.entity.ArtistEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArtistService {
//    Interface that will be used to define all the bussiness logic
    List<ArtistEntity> getAllTrackId();
    ArtistEntity getTrackById(Long id);
    ArtistEntity createNewTrackId(NewArtisstDto newArtisstDto);
    void deleteTrackId(Long id);
    ArtistEntity updateTrackId(Long id,NewArtisstDto newArtisstDto);
    List<ArtistEntity> getTracksByRatingAbove(Float rating);
    List<ArtistEntity> getTracksByArtistName(String artistName);
}
