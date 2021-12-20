package com.example.leprac11;

import javafx.fxml.FXML;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.Arrays;

public class HelloController {
    @FXML
    private TextField input;

    private boolean trigger = false;

    private double firstOperand;
    private double secondOperand;
    private int numberOperation;

    @FXML
    private Label output;

    @FXML
    private Text text;

    public double toDouble(String s) {
        return Double.parseDouble(s);
    }

    public void onActionEnter() {
        if (!trigger) {
            firstOperand = toDouble(input.getText());
            trigger = true;
        }
        else {
            secondOperand = toDouble(input.getText());
            trigger = false;
        }
    }

    public double Calculating() {
        switch (numberOperation) {
            case 0:
                return firstOperand+secondOperand;
            case 1:
                return firstOperand-secondOperand;
            case 2:
                return firstOperand/secondOperand;
            case 3:
                return firstOperand*secondOperand;
            default:
                return firstOperand;
        }
    }


    public void OnMouseClick(MouseEvent mouseEvent) {
        Button button = (Button) mouseEvent.getSource();
        switch (button.getText()) {
            case "+":
                onActionEnter();
                numberOperation = 0;
                input.clear();
                text.setText("Input a second number and press on equal");
                break;
            case "-":
                onActionEnter();
                numberOperation = 1;
                input.clear();
                text.setText("Input a second number and press on equal");
                break;
            case "/":
                onActionEnter();
                numberOperation = 2;
                input.clear();
                text.setText("Input a second number and press on equal");
                break;
            case "*":
                onActionEnter();
                numberOperation = 3;
                input.clear();
                text.setText("Input a second number and press on equal");
                break;
            case "=":
                onActionEnter();
                output.setText(Double.toString(Calculating()));
                text.setText("Your result!");
                break;
            case "C":
                trigger = false;
                input.clear();
                output.setText("");
                text.setText("Input a number and press on operation");

        }

    }
}