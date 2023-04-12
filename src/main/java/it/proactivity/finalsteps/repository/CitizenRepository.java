package it.proactivity.finalsteps.repository;

import it.proactivity.finalsteps.model.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {

    @Query("SELECT c.id FROM Citizen c ORDER BY id DESC")
    Optional<Long> findLastId();
}
