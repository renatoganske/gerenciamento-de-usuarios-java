package net.lyncas.repository;

import net.lyncas.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    Boolean existsByEmail(String email);


}
