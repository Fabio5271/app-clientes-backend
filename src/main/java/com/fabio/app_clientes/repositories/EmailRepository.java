package com.fabio.app_clientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabio.app_clientes.entities.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
    
}
