package com.back_barber_system.service.impl;

import org.springframework.stereotype.Service;

import com.back_barber_system.models.Schedule;
import com.back_barber_system.repository.ScheduleRepository;
import com.back_barber_system.service.IScheduleService;
import com.back_barber_system.service.query.IScheduleQueryService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ScheduleService implements IScheduleService {

    private final ScheduleRepository repository;
    private final IScheduleQueryService queryService;


    @Override
    public Schedule save(final Schedule entity) {
        queryService.verifyIfScheduleExists(entity.getStartAt(), entity.getEndAt());
        return repository.save(entity);
    }

    @Override
    public void delete(long id) {
        queryService.findById(id);
        repository.deleteById(id);
    }
}
