package com.ingg.ipas;

import com.ingg.ipas.models.auth.ERole;
import com.ingg.ipas.models.auth.Role;
import com.ingg.ipas.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private RoleRepository repository;

    @Autowired
    public void setRepository(RoleRepository repository) {
        this.repository = repository;
    }

    public void run(ApplicationArguments args) {
        if(repository.count() > 0){
            return;
        }
        repository.save(new Role(ERole.ROLE_ADMIN));
        repository.save(new Role(ERole.ROLE_USER));
        repository.save(new Role(ERole.ROLE_MODERATOR));
    }
}
