package com.back_barber_system.service.impl;

import org.springframework.stereotype.Service;

import com.back_barber_system.models.Client;
import com.back_barber_system.repository.ClientRepository;
import com.back_barber_system.service.IClientService;
import com.back_barber_system.service.query.IClientQueryService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class ClientService implements IClientService {

    private final ClientRepository repository;
    
    private final IClientQueryService queryService;

    @Override
    public Client save(final Client entity) {
        queryService.verifyEmail(entity.getEmail());
        queryService.verifyPhone(entity.getPhone());

        return repository.save(entity);
    }

    @Override
    public Client update(final Client entity) {
        queryService.verifyEmail(entity.getId(), entity.getEmail());
        queryService.verifyPhone(entity.getId(), entity.getPhone());

        var stored =queryService.findById(entity.getId());
        stored.setName(entity.getName());
        stored.setPhone(entity.getPhone());
        stored.setEmail(entity.getEmail());

        return repository.save(stored);
    }

    @Override
    public void delete(final long id) {
        queryService.findById(id);
        repository.deleteById(id);
    }
}