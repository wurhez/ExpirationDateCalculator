package com.example.calculator;

import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

public class HelloController {

    @FXML
    private DatePicker dateOfBirthField;

    @FXML
    private Button getExpiryDateButton;

    @FXML
    private Label expDate;

    @FXML
    void initialize(){

        getExpiryDateButton.setOnAction(event -> {

            LocalDate dateOfBirth = dateOfBirthField.getValue();
            int year = dateOfBirth.getYear();
            int month = dateOfBirth.getMonthValue();
            int day = dateOfBirth.getDayOfMonth();

            LocalDate getInstance = LocalDate.now();
            LocalDate expiryDate = LocalDate.of(year, month, day);
            boolean stop = false;

            int age = getInstance.getYear() - dateOfBirth.getYear();
            if (getInstance.getDayOfYear() <= dateOfBirth.getDayOfYear())
                age--;

            if (age <= 20) {

                expiryDate = expiryDate.plusYears(20);
                expiryDate = expiryDate.plusDays(90);

            } else if (age <= 45) {

                expiryDate = expiryDate.plusYears(45);
                expiryDate = expiryDate.plusDays(90);

            } else {

                stop = true;
                expDate.setText("Бессрочный документ");

            }

            if (!stop) {

                expDate.setText(expiryDate.toString());
                System.out.println(expiryDate);

            }
        });
    }
}

