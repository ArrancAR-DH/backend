package com.ArrancAR.ArrancAR.service;

import java.io.File;

public interface EmailService {

    void sendEmail(String toUser, String fullName);
    void sendEmailReserved(String toUser, String fullName);

}
