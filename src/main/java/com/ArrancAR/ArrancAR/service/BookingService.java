package com.ArrancAR.ArrancAR.service;


import com.ArrancAR.ArrancAR.dto.BookingRequestDto;
import com.ArrancAR.ArrancAR.dto.BookingResponseDto;
import com.ArrancAR.ArrancAR.mapper.BookingDtoConverter;
import com.ArrancAR.ArrancAR.repository.BookingRepository;
import com.ArrancAR.ArrancAR.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    BookingDtoConverter bookingDtoConverter;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    UserRepository

    public BookingResponseDto reservar(BookingRequestDto requestDto) {
        User user = user
    }
}
