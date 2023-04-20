package com.example.calculator;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.DateFormat;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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

            Calendar dobToExpiryDate = new GregorianCalendar(year, month-1, day);  // дата рождения
            Calendar today = Calendar.getInstance(); // текущая дата
            boolean stop = false; // флажок для остановки принта, в случаях бессрочного паса

            int age = today.get(Calendar.YEAR) - dobToExpiryDate.get(Calendar.YEAR);
            if (today.get(Calendar.DAY_OF_YEAR) <= dobToExpiryDate.get(Calendar.DAY_OF_YEAR))
                age--;
            System.out.println(age);

            if (age <= 20) {

                dobToExpiryDate.add(Calendar.YEAR, 20);
                dobToExpiryDate.add(Calendar.DAY_OF_YEAR, 90);

            } else if (age > 20 && age <= 45) {

                dobToExpiryDate.add(Calendar.YEAR, 45);
                dobToExpiryDate.add(Calendar.DAY_OF_YEAR, 90);

            } else {

                stop = true;
                System.out.println("Бессрочный документ");

            }

            if (!stop) {

                DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
                System.out.println(dateFormat.format(dobToExpiryDate.getTime()));
                expDate.setText(dateFormat.format((dobToExpiryDate.getTime())));

            }

        });

    }
}

