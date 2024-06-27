package com.ArrancAR.ArrancAR.service;

import com.ArrancAR.ArrancAR.controller.MailController;
import com.ArrancAR.ArrancAR.dto.BookingResponseDto;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

@Service
public class EmailServiceImpl implements EmailService {


    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.web.hostname}")
    private String webHost;

    @Autowired
    private JavaMailSender mailSender;


    private String htmlTemplateWelcome = "<html>\n" +
            "  <head>\n" +
            "    <link rel=\"stylesheet\" href=\"styles.css\">\n" +
            "  </head>\n" +
            "  <body>\n" +
            "    <h1>¡Te damos la bienvenida a ArrancAR!</h1>\n" +
            "    <p>Por favor, haz clic en el siguiente botón para iniciar sesión:</p>\n" +
            "    <a href=\"http://34.234.216.198/login\" class=\"button\">Iniciar Sesión</a>\n" +
            "    <p>Si tienes alguna pregunta o necesitas ayuda, no dudes en contactarnos.</p>\n" +
            "  </body>\n" +
            "  </html>";


    @Override
    public void sendEmail(String toUser, String fullName) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, StandardCharsets.UTF_8.name());

            mimeMessageHelper.setFrom(username);
            mimeMessageHelper.setTo(toUser);
            mimeMessageHelper.setSubject("Bienvenido a ArrancAR!");
            mimeMessageHelper.setText("Hola," + fullName + "!"+ htmlTemplateWelcome, true);

            mailSender.send(mimeMessage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendEmailReserved(String toUser, String fullName, LocalDate startsOn, LocalDate endsOn, String nameVehicle) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, StandardCharsets.UTF_8.name());

            mimeMessageHelper.setFrom(username);
            mimeMessageHelper.setTo(toUser);
            mimeMessageHelper.setSubject("Confirmación de reserva - ArrancAr");
            mimeMessageHelper.setText("Hola," + fullName + "!"+ "<html>\n" +
                    "  <head>\n" +
                    "  </head>\n" +
                    "  <body>\n" +
                    "<h1>¡Tu reserva ha sido confirmada!</h1>\n" +
                    "<p>Gracias por reservar con ArrancAR. Aquí tienes los detalles de tu reserva:</p>\n" +
                    "<p><strong>Nombre:</strong> " + fullName + "</p>" +
                    "<p><strong>Vehículo:</strong> " + nameVehicle +" </p>" +
                    "<p><strong>Fecha de inicio:</strong> " + startsOn +" </p>" +
                    "<p><strong>Fecha de Fin:</strong> " + endsOn +" </p>" +
                    "<p>Si tienes alguna pregunta o necesitas ayuda, no dudes en contactarnos.</p>" +
                    "</body>\n" +
                    "</html>"
                    , true);

            mailSender.send(mimeMessage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
