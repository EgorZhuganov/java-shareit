package ru.practicum.shareit.booking.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import ru.practicum.shareit.booking.model.Booking;
import ru.practicum.shareit.item.model.Item;
import ru.practicum.shareit.user.model.User;

import java.time.LocalDate;

@Value
@Getter
@Builder
public class BookingReadDto {

    Long id;
    LocalDate start;
    LocalDate end;
    Long itemId;
    Long bookerId;
    String status;

}
