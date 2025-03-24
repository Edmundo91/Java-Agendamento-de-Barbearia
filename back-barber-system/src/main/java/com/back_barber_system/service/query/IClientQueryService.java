package com.back_barber_system.service.query;

import java.util.List;

import com.back_barber_system.models.Client;

public interface IClientQueryService {

	

    Client findById(final long id);

    List<Client> list();

    void verifyPhone(final String phone);

    void verifyPhone(final long id,final String phone);

    void verifyEmail(final String email);

    void verifyEmail(final long id,final String email);
	
	
	
}
