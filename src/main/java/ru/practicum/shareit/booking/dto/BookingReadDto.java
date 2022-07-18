package ru.practicum.shareit.booking.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Getter
@Builder
public class BookingReadDto {

    Long id;
    LocalDateTime startDateTime;
    LocalDateTime endDateTime;
    Long itemId;
    Long bookerId;
    String status;

}
