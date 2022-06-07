package net.lyncas.repository;

import net.lyncas.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    Boolean existsByEmail(String email);

    Optional<PersonEntity> findByEmail(String email);

}
