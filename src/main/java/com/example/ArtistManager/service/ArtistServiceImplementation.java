package com.example.ArtistManager.service;

import com.example.ArtistManager.dto.ArtistDto;
import com.example.ArtistManager.dto.NewArtisstDto;
import com.example.ArtistManager.entity.ArtistEntity;
import com.example.ArtistManager.repository.ArtistEntityRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ArtistServiceImplementation implements ArtistService{

    @Autowired
    ArtistEntityRepository artistEntityRepository;

    @Override
    public List<ArtistEntity> getAllTrackId() {
        return artistEntityRepository.findAll();
    }

    @Override
    public ArtistEntity getTrackById(Long id) {
        return artistEntityRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Track Id Not Found"));
    }

    @Override
    public ArtistEntity createNewTrackId(NewArtisstDto newArtisstDto) {
        ArtistEntity artistEntity = new ArtistEntity();

        artistEntity.setTrackName(newArtisstDto.getTrackName());
        artistEntity.setTrackComments(newArtisstDto.getTrackComments());
        artistEntity.setTrackRating(newArtisstDto.getTrackRating());
        artistEntity.setTrackArtist(newArtisstDto.getTrackArtist());

        return artistEntityRepository.save(artistEntity);
    }

    @Override
    public void deleteTrackId(Long id) {
        if(!artistEntityRepository.existsById(id)){
            throw new IllegalArgumentException("Student does not Exist"+ id);
        }
        artistEntityRepository.deleteById(id);
    }

    @Override
    public ArtistEntity updateTrackId(Long id, NewArtisstDto newArtisstDto) {
        ArtistEntity existing = artistEntityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Track not found with ID: " + id));

        existing.setTrackName(newArtisstDto.getTrackName());
        existing.setTrackComments(newArtisstDto.getTrackComments());
        existing.setTrackRating(newArtisstDto.getTrackRating());
        existing.setTrackArtist(newArtisstDto.getTrackArtist());

        return artistEntityRepository.save(existing);
    }
    @Override
    public List<ArtistEntity> getTracksByRatingAbove(Float rating) {
        List<ArtistEntity> allTracks = artistEntityRepository.findAll();
        List<ArtistEntity> result = new ArrayList<>();

        for (ArtistEntity track : allTracks) {
            if (track.getTrackRating() != null && track.getTrackRating() > rating) {
                result.add(track);
            }
        }

        return result;
    }

    @Override
    public List<ArtistEntity> getTracksByArtistName(String artistName) {
        List<ArtistEntity> allTracks = artistEntityRepository.findAll();
        List<ArtistEntity> result = new ArrayList<>();

        for (ArtistEntity track : allTracks) {
            if (track.getTrackArtist() != null) {
                for (String artist : track.getTrackArtist()) {
                    if (artist.equalsIgnoreCase(artistName)) {
                        result.add(track);
                        break; // stop checking once artist found
                    }
                }
            }
        }

        return result;
    }
}
