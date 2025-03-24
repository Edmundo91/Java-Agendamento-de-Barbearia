package com.back_barber_system.service.query.impl;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.back_barber_system.exception.NotFoundException;
import com.back_barber_system.exception.ScheduleInUseException;
import com.back_barber_system.models.Schedule;
import com.back_barber_system.repository.ScheduleRepository;
import com.back_barber_system.service.query.IScheduleQueryService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ScheduleQueryService implements IScheduleQueryService {

    private final ScheduleRepository repository;

    @Override
    public Schedule findById(final long id) {
        return repository.findById(id).orElseThrow(
                () -> new NotFoundException("Agendamento não encontrado.")
        );
    }

    @Override
    public List<Schedule> findInMonth(final OffsetDateTime startAt, OffsetDateTime endAt) {
        return repository.findByStartAtGreaterThanEqualAndEndAtLessThanEqualOrderByStartAtAscEndAtAsc(startAt, endAt);
    }

    @Override
    public void verifyIfScheduleExists(OffsetDateTime startAt, OffsetDateTime endAt) {
        if (repository.existsByStartAtAndEndAt(startAt, endAt)){
            var message = "Já existe um cliente agendado no horário solicitado";
            throw new ScheduleInUseException(message);
        }
    }
}
