package com.back_barber_system.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.back_barber_system.controller.request.SaveClientRequest;
import com.back_barber_system.controller.request.UpdateClientRequest;
import com.back_barber_system.controller.response.ClientDetailResponse;
import com.back_barber_system.controller.response.ListClientResponse;
import com.back_barber_system.controller.response.SaveClientResponse;
import com.back_barber_system.controller.response.UpdateClientResponse;
import com.back_barber_system.models.Client;

@Mapper(componentModel = "spring")
public interface IClientMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "schedules", ignore = true)
    Client toEntity(final SaveClientRequest request);

    SaveClientResponse toSaveResponse(final Client entity);

    @Mapping(target = "schedules", ignore = true)
    Client toEntity(final long id, final UpdateClientRequest request);

    UpdateClientResponse toUpdateResponse(final Client entity);

    ClientDetailResponse toDetailResponse(final Client entity);

    List<ListClientResponse> toListResponse(final List<Client> entities);

}