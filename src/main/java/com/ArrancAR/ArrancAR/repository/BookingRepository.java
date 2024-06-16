package com.ArrancAR.ArrancAR.repository;

import com.ArrancAR.ArrancAR.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    Optional<List<Booking>> findByIdVehicle(Long id);

    List<Booking> findByStartDateLessThanEqualAndEndDateGreaterThanEqual(LocalDate startsOn, LocalDate endsOn);


}
