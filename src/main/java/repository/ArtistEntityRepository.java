package repository;

import entity.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistEntityRepository extends JpaRepository<ArtistEntity, Long> {
}