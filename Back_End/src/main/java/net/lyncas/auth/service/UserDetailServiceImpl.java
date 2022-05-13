package net.lyncas.auth.service;

import net.lyncas.auth.data.UserDetailData;
import net.lyncas.entities.PersonEntity;
import net.lyncas.repository.PersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailServiceImpl implements UserDetailsService {

    private final PersonRepository repository;

    public UserDetailServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<PersonEntity> person = repository.findByEmail(username);

        if (person.isEmpty()) {
            throw new UsernameNotFoundException("Usuário [" + username +"] não encontrado.");
        }

        return new UserDetailData(person);
    }

    @Bean
    public PasswordEncoder getPasswordEnconder() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
}
