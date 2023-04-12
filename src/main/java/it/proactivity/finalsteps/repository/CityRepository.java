package it.proactivity.finalsteps.repository;

import it.proactivity.finalsteps.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query("SELECT c.id FROM City c ORDER BY id DESC")
    Optional<Long> findLastId();

}
