package com.back_barber_system.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.back_barber_system.controller.request.SaveScheduleRequest;
import com.back_barber_system.controller.response.ClientScheduleAppointmentResponse;
import com.back_barber_system.controller.response.SaveScheduleResponse;
import com.back_barber_system.controller.response.ScheduleAppointmentMonthResponse;
import com.back_barber_system.models.Schedule;

@Mapper(componentModel = "spring")
public interface IScheduleMapper {


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "client.id", source = "clientId")
    Schedule toEntity(final SaveScheduleRequest request);

    @Mapping(target = "clientId", source = "client.id")
    SaveScheduleResponse toSaveResponse(final Schedule entity);

    @Mapping(target = "scheduledAppointments", expression = "java(toClientMonthResponse(entities))")
    ScheduleAppointmentMonthResponse toMonthResponse(final int year, final int month, final List<Schedule> entities);

    List<ClientScheduleAppointmentResponse> toClientMonthResponse(final List<Schedule> entities);

    @Mapping(target = "clientId", source = "client.id")
    @Mapping(target = "clientName", source = "client.name")
    @Mapping(target = "day", expression = "java(entity.getStartAt().getDayOfMonth())")
    ClientScheduleAppointmentResponse toClientMonthResponse(final Schedule entity);
}