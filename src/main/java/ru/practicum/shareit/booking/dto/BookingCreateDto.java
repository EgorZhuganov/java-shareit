package ru.practicum.shareit.booking.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Value
@Getter
@Builder
public class BookingCreateDto {

    @NotNull
    LocalDate start;
    @NotNull
    LocalDate end;
    @NotNull
    Long itemId;
    @NotNull
    Long bookerId;
    //TODO посмотреть как будет реализованна передача поля Status, реализовать маппинг

}
