package net.lyncas.entities;

import net.lyncas.dtos.AuthDto;
import net.lyncas.dtos.PersonDto;
import net.lyncas.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class SeederUser implements CommandLineRunner {

    @Autowired
    PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
        databaseSeederUser();
    }

    private void databaseSeederUser() {
        if (personRepository.count() == 0) {
            AuthenticationEntity auth = new AuthenticationEntity();
            auth.setIdAuth(1L);
            auth.setStatus(true);
            auth.setPassword("$2a$12$cqhHDUx/xHN3NnozNoLtUextoNX9d4ujd377zpMAKFZ1kVyKShA0a");
            //senha do usuário seeder: admin123

            PersonEntity seeder = new PersonEntity();
            seeder.setpersonId(1L);
            seeder.setAuthentication(auth);
            seeder.setName("Admin");
            seeder.setLastname("User");
            seeder.setEmail("admin@admin.com");
            seeder.setPhone("(47)99999-9999");
            seeder.setBirth_date(LocalDate.now());
            auth.setPersonEntity(seeder);
            personRepository.save(seeder);
        }
    }
}

