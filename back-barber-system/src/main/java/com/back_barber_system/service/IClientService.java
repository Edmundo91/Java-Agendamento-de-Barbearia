package com.back_barber_system.service;

import com.back_barber_system.models.Client;

public interface IClientService {

	
	
	Client save(final Client entity);

	 Client update(final Client entity);

	  void delete(final long id);
	
	
}
