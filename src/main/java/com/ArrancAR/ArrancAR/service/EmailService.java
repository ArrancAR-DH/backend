package com.ArrancAR.ArrancAR.service;

import java.io.File;
import java.time.LocalDate;

public interface EmailService {

    void sendEmail(String toUser, String fullName);
    void sendEmailReserved(String toUser, String fullName, LocalDate startsOn, LocalDate endsOn, String nameVehicle);

}
