package ru.practicum.shareit.booking.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

import static lombok.AccessLevel.PRIVATE;

@Builder
@Getter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = PRIVATE)
public class BookingUpdateDto {

    LocalDate start;
    LocalDate end;
    Long itemId;
    Long bookerId;

}
