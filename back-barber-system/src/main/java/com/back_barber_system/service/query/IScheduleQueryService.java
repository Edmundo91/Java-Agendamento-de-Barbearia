package com.back_barber_system.service.query;

import java.time.OffsetDateTime;
import java.util.List;

import com.back_barber_system.models.Schedule;

public interface IScheduleQueryService {

	

    Schedule findById(final long id);

    List<Schedule> findInMonth(final OffsetDateTime startAt, final OffsetDateTime endAt);

    void verifyIfScheduleExists(final OffsetDateTime startAt, final OffsetDateTime endAt);

	
	
	
}
