package com.back_barber_system.service.query.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.back_barber_system.exception.EmailInUseException;
import com.back_barber_system.exception.NotFoundException;
import com.back_barber_system.exception.PhoneInUseException;
import com.back_barber_system.models.Client;
import com.back_barber_system.repository.ClientRepository;
import com.back_barber_system.service.query.IClientQueryService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ClientQueryService implements IClientQueryService {
	
	   private final ClientRepository repository;


	    @Override
	    public Client findById(long id) {
	        return repository.findById(id).orElseThrow(
	                () -> new NotFoundException("Não foi encontrado o cliente de id" + id)
	        );
	    }

	    @Override
	    public List<Client> list() {
	        return repository.findAll();
	    }

	    @Override
	    public void verifyPhone(final String phone) {
	    if(repository.existsByPhone(phone)){
	        var message = "O telefone" + phone + "já está em uso";
	        throw new PhoneInUseException(message);
	    }
	    }

	    @Override 
	    public void verifyPhone(final long id, String phone) {
	        var optional = repository.findByPhone(phone);
	        if (optional.isPresent() && !Objects.equals(optional.get().getPhone(), phone)){
	            var message = "O telefone" + phone +"já está em uso";
	            throw  new PhoneInUseException(message);
	        }
	    }

	    @Override
	    public void verifyEmail(final String email) {
	        if(repository.existsByEmail(email)){
	            var message = "O email" + email + "já está em uso";
	            throw new EmailInUseException(message);
	        }
	    }

	    @Override
	    public void verifyEmail(final long id, String email) {
	        var optional = repository.findByEmail(email);
	        if (optional.isPresent() && !Objects.equals(optional.get().getEmail(), email)){
	            var message = "O email" + email +"já está em uso";
	            throw  new EmailInUseException(message);
	        }
	    }





}