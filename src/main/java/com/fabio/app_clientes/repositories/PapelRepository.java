package com.fabio.app_clientes.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabio.app_clientes.entities.Papel;

public interface PapelRepository extends JpaRepository<Papel, Long>{
    Optional<Papel> findByNome(String nome);
}
