package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculatorController {

    private Parent root;
    private Scene scene;
    private Stage stage;

    private double number1=0;
    private String operator="";

    @FXML
    private Label result;

    @FXML
    void NumberClicked(MouseEvent event) {
        int value=Integer.parseInt(((Pane)event.getSource()).getId().replace("button",""));
        result.setText(Double.parseDouble(result.getText())==0 ? String.valueOf((double)value) : String.valueOf(Double.parseDouble(result.getText())*10+value));
    }

    @FXML
    void OperatorClicked(MouseEvent event) {
        String symbol= ((Pane)event.getSource()).getId().replace("button","");
        if(symbol.equals("equals")){
            double number2=Double.parseDouble(result.getText());
            switch(operator){
                case "+": result.setText(number1+number2+""); break;
                case "*": result.setText(number1*number2+""); break;
                case "/":
                    if(number2==0){
                        result.setText("Błąd");
                        break;
                    }
                    result.setText(number1/number2+"");
                    break;

                case "-": result.setText(number1-number2+""); break;
            }
        }
        else if(symbol.equals("clear")){
            result.setText(String.valueOf(0.0));
            operator="";
        }
        else{
            switch(symbol){
                case "plus" : operator="+"; break;
                case "minus" : operator="-"; break;
                case "divide" : operator="/"; break;
                case "times" : operator="*"; break;
            }
            number1=Double.parseDouble(result.getText());
            result.setText(String.valueOf(0.0));
        }
    }
    @FXML
     void switchToSceneCalcScene (MouseEvent event)
    {
        try {
            root = FXMLLoader.load(getClass().getResource("Calc.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void switchToSceneMainScene(MouseEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void switchToSceneNoteScene(MouseEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("Note.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}