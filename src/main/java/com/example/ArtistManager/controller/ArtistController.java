package com.example.ArtistManager.controller;


import com.example.ArtistManager.dto.NewArtisstDto;
import com.example.ArtistManager.entity.ArtistEntity;
import com.example.ArtistManager.repository.ArtistEntityRepository;
import com.example.ArtistManager.service.ArtistService;
import com.example.ArtistManager.service.ArtistServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/track")
public class ArtistController {
   @Autowired
    ArtistEntityRepository artistEntityRepository;
   @Autowired
    ArtistServiceImplementation artistServiceImplementation;

   @GetMapping
    public ResponseEntity<List<ArtistEntity>> getAllTrackId(){
       return ResponseEntity.ok(artistServiceImplementation.getAllTrackId());
   }

   @GetMapping("/{id}")
    public ResponseEntity<ArtistEntity> getByTrackId(@PathVariable Long id){
       return ResponseEntity.ok(artistServiceImplementation.getTrackById(id));
   }

    @PostMapping
    public ResponseEntity<ArtistEntity> createNewTrackId(@RequestBody @Validated NewArtisstDto artistDto) {
        ArtistEntity newArtistEntity = artistServiceImplementation.createNewTrackId(artistDto);
        return new ResponseEntity<>(newArtistEntity, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArtistEntity> updateTrackId(
            @PathVariable Long id,
            @RequestBody @Validated NewArtisstDto artistDto) {

        ArtistEntity updatedTrack = artistServiceImplementation.updateTrackId(id, artistDto);
        return ResponseEntity.ok(updatedTrack);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByTrackId(@PathVariable Long id){
        artistServiceImplementation.deleteTrackId(id);
        return ResponseEntity.noContent().build();
    }


}
