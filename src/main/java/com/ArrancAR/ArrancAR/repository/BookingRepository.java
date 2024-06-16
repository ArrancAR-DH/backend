package com.ArrancAR.ArrancAR.repository;

import com.ArrancAR.ArrancAR.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    Optional<List<Booking>> findByIdVehicle(Long id);
    
    @Query("SELECT b FROM Booking b WHERE b.idVehicle = :idVehicle AND " +
            "(:startsOn BETWEEN b.startsOn AND b.endsOn OR :endsOn BETWEEN b.startsOn AND b.endsOn OR " +
            "b.startsOn BETWEEN :startsOn AND :endsOn OR b.endsOn BETWEEN :startsOn AND :endsOn)")

    List<Booking> findOverlappingBookings(@Param("idVehicle") Long idVehicle, @Param("startsOn") LocalDate startsOn, @Param("endsOn") LocalDate endsOn);
}
