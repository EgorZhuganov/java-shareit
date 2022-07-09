package ru.practicum.shareit.booking.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.practicum.shareit.booking.dto.BookingUpdateDto;
import ru.practicum.shareit.booking.model.Booking;

@Component
@RequiredArgsConstructor
public class BookingUpdateMapper {

    //TODO TDD, проверить какие поля изменяются, когда появятся тесты

    public Booking mapFrom(Booking toObject, BookingUpdateDto fromDto) {
        toObject.setBooker(null);
        toObject.setItem(null);
        toObject.setEndDateTime(null);
        toObject.setStartDateTime(null);
        toObject.setStatus(null);
        return toObject;
    }

}
