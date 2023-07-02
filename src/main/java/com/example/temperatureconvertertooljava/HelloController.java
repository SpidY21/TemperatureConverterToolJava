package com.example.temperatureconvertertooljava;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    public Label WelcomeLable;
    @FXML
    public ChoiceBox<String> ChoiceBox;
    @FXML
    public TextField txtField;
    @FXML
    public Button Btn;

    private boolean isTrue = true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ChoiceBox.getItems().add("Celsius to Fahrenheit");
        ChoiceBox.getItems().add("Fahrenheit to Celsius");
        ChoiceBox.setValue("Celsius to Fahrenheit");
        ChoiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> isTrue = t1.equals("Celsius to Fahrenheit"));
        Btn.setOnAction(actionEvent -> {
//            System.out.println("button Clicked");
            convert();
        });

    }

    private void convert() {
        String input = txtField.getText();
        float temp = 0.0f;
        float newTemp = 0.0f;
        try {
            temp = Float.parseFloat(input);
            if (isTrue) {
                newTemp = (temp * 9 / 5) + 32;
            } else {
                newTemp = (temp - 32) * 5 / 9;
            }
            if (isTrue) {
                newTemp = (temp * 9 / 5) + 32;
            } else {
                newTemp = (temp - 32) * 5 / 9;
            }
            display(newTemp);
        } catch (Exception e) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error");
            error.setHeaderText("Some Error has occurred");
            error.setContentText("Please Enter valid input!!");
            error.show();
        }
    }

    private void display(float newTemp) {
        String unit = isTrue ? "F" : "C";
        System.out.println("The converted Temp is: " + newTemp + unit);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setHeaderText("This is your answer.");
        alert.setContentText("The converted Temp is: " + newTemp + unit);
        alert.show();
    }
}
