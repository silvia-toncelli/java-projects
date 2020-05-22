/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dategui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import java.util.function.UnaryOperator;
import java.time.DayOfWeek;
import java.time.*;
/**
 *
 * @author rache
 */
public class DateGUI extends Application 
{

    /**
     * @param args the command line arguments
     */
    @Override
    public void start(Stage primaryStage) 
    {
        GridPane root = new GridPane();
    
	root.setHgap(10);
	root.setVgap(10);
	root.setPadding(new Insets(10, 10, 10, 10));
        
        Label monthLabel = new Label("Month");
	TextField monthInput = new TextField();
        
        Label dayLabel = new Label("Day");
	TextField dayInput = new TextField();
        
        Label yearLabel=new Label("Year");
        TextField yearInput=new TextField();
        
        Label convertedLabel = new Label("Day of Week");
	TextField convertedInput = new TextField();
        convertedInput.setEditable(false);
        
        Button convertButton = new Button("Calculate");
	convertButton.setOnAction((event) -> 
        {
            String month = monthInput.getText();
            int m=Integer.parseInt(month);
            String day = dayInput.getText();
            int d=Integer.parseInt(day);
            String year = yearInput.getText();
            int y=Integer.parseInt(year);
            String outDate = convertDate(m, d, y);
            if (outDate != null) {
            convertedInput.setText(outDate);
            } else {
            convertedInput.setText("");

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Date");
            alert.setHeaderText(null);
            alert.setContentText("You have entered an invalid "
                                    + "date.");
            alert.showAndWait();
            }
	});
        convertButton.setDisable(true);
        
        UnaryOperator<TextFormatter.Change> filter = new 
			UnaryOperator<TextFormatter.Change>() {
  	public TextFormatter.Change apply(
			TextFormatter.Change change)
  	{
    			convertButton.setDisable(true);
   	 
    	String newText = change.getControlNewText();
    	if (newText.trim().length() != 0) {
      			if (newText.matches("^-?\\.?$")) {
        	// let this change through
      	} else {
        				try {
          	Double.parseDouble(newText);
          	convertButton.setDisable(false);
        	} catch (NumberFormatException ex) {
          	// was the old text valid?
			// keep button accessible,
			// since the control will revert
          	String oldText = change.getControlText();
          	try {
            	Double.parseDouble(oldText);
            	convertButton.setDisable(false);
          	} catch (NumberFormatException ex2) {}
          	return null;
        	}
      	}
    	}
   	 
    	return change;
  	}
	};
        
        monthInput.setTextFormatter(new 
		TextFormatter<Double>(filter));
        dayInput.setTextFormatter(new 
		TextFormatter<Double>(filter));
        yearInput.setTextFormatter(new 
		TextFormatter<Double>(filter));
        
        root.add(monthLabel, 0, 0);
	root.add(monthInput, 1, 0);
        
        root.add(dayLabel, 0, 1);
	root.add(dayInput, 1, 1);
        
        root.add(yearLabel, 0, 2);
	root.add(yearInput, 1, 2);
        
        root.add(convertedLabel, 0, 3);
	root.add(convertedInput, 1, 3);
        
        root.add(convertButton, 1, 4);
	
        Scene scene = new Scene(root);
    
	primaryStage.setTitle("Date");
	primaryStage.setScene(scene);
    
	primaryStage.sizeToScene();
    
	primaryStage.show();
    }
    
    public static String convertDate(int month, int day, int year)
    {
        Month m= Month.of(month);
        LocalDate localDate = LocalDate.of(year, m, day); 
        DayOfWeek d=DayOfWeek.from(localDate);
        return d.name();
    }
    
    public static void main(String[] args) 
    {
        // TODO code application logic here
        launch(args);
    }
    
}
