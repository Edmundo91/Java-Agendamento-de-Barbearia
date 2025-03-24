package com.back_barber_system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back_barber_system.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	
	 boolean existsByEmail(final String email);

	 boolean existsByPhone(final String phone);

	 Optional<Client> findByEmail(final String email);

	 Optional<Client> findByPhone(final String phone);
	
	
}
