package ru.practicum.shareit.booking.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.practicum.shareit.booking.dto.BookingCreateDto;
import ru.practicum.shareit.booking.Booking;
import ru.practicum.shareit.item.repository.ItemRepository;
import ru.practicum.shareit.user.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class BookingCreateMapper {

    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    public Booking mapFrom(BookingCreateDto dto) {
        return Booking.builder()
                .startDateTime(dto.getStartDateTime())
                .endDateTime(dto.getEndDateTime())
                .item(itemRepository.findById(dto.getItemId()).orElseThrow())
                .booker(userRepository.findById(dto.getBookerId()).orElseThrow())
                .build();

    }

}
