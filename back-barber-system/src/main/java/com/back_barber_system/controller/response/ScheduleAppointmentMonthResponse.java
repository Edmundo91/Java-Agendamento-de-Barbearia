package com.back_barber_system.controller.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ScheduleAppointmentMonthResponse(
        @JsonProperty("year")
        int year,
        @JsonProperty("month")
        int month,
        List<ClientScheduleAppointmentResponse> scheduledAppointments
) {}
