package com.ArrancAR.ArrancAR.mapper;

import com.ArrancAR.ArrancAR.dto.BookingRequestDto;
import com.ArrancAR.ArrancAR.dto.BookingResponseDto;
import com.ArrancAR.ArrancAR.entity.Booking;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingDtoConverter {

    @Autowired
    private ModelMapper modelMapper;

    public BookingRequestDto convertBookingToBookingRequestDto(Booking booking) {
        BookingRequestDto bookingRequestDto = modelMapper.map(booking, BookingRequestDto.class);
        return bookingRequestDto;
    }

    public Booking convertBookingToBookingRequestDto(BookingRequestDto bookingRequestDto) {
        Booking booking = modelMapper.map(bookingRequestDto, Booking.class);
        return booking;
    }

    public BookingResponseDto convertBookingToBookingResponseDto(Booking booking) {
        BookingResponseDto bookingResponseDto = modelMapper.map(booking, BookingResponseDto.class);
        return bookingResponseDto;
    }

    public Booking convertBookingResponseDtoToBooking(BookingResponseDto bookingResponseDto) {
        Booking booking = modelMapper.map(bookingResponseDto, Booking.class);
        return booking;
    }
}
