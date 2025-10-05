package com.example.ArtistManager.repository;

import com.example.ArtistManager.entity.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistEntityRepository extends JpaRepository<ArtistEntity, Long> {
}