package com.nishant.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nishant.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {

}
