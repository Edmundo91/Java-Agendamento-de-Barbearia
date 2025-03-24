package com.back_barber_system.service;

import com.back_barber_system.models.Schedule;

public interface IScheduleService {

	
	 Schedule save(final Schedule entity);

	    void delete(final long id);
	
	
}
