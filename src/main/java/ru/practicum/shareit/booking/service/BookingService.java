package ru.practicum.shareit.booking.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.booking.mapper.BookingCreateMapper;
import ru.practicum.shareit.booking.mapper.BookingReadMapper;
import ru.practicum.shareit.booking.mapper.BookingUpdateMapper;
import ru.practicum.shareit.booking.repository.BookingRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingCreateMapper bookingCreateMapper;
    private final BookingReadMapper bookingReadMapper;
    private final BookingUpdateMapper bookingUpdateMapper;

}
