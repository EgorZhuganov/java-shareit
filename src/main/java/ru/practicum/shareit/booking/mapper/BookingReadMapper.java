package ru.practicum.shareit.booking.mapper;

import org.springframework.stereotype.Component;
import ru.practicum.shareit.booking.dto.BookingReadDto;
import ru.practicum.shareit.booking.model.Booking;

@Component
public class BookingReadMapper {

    public BookingReadDto mapFrom(Booking booking) {
        return BookingReadDto.builder()
                .id(booking.getId())
                .startDateTime(booking.getStartDateTime())
                .endDateTime(booking.getEndDateTime())
                .bookerId(booking.getBooker().getId())
                .itemId(booking.getItem().getId())
                .status(booking.getStatus().name())
                .build();
    }

}
