package ru.gb.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.auth.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);

}
