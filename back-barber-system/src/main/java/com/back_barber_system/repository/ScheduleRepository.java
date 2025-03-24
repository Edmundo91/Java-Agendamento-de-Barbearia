package com.back_barber_system.repository;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back_barber_system.models.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

	
    //para buscar todos os agendamentos feitos entre as datas passadas
    List<Schedule> findByStartAtGreaterThanEqualAndEndAtLessThanEqualOrderByStartAtAscEndAtAsc(
            final OffsetDateTime startAt,
            final OffsetDateTime endAt
    );

    boolean existsByStartAtAndEndAt(final OffsetDateTime startAt, final OffsetDateTime endAt);
	
	
	
	
	
}
