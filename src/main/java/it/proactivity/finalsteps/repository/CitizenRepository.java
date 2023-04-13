package it.proactivity.finalsteps.repository;

import it.proactivity.finalsteps.model.Citizen;
import it.proactivity.finalsteps.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {
    @Query("SELECT max(id) + 1 FROM Citizen")
    Optional<Long> findNextId();

    Optional<Citizen> findByFiscalCode(String fiscalCode);
}
