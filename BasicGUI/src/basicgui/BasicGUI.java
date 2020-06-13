

package basicgui;

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

public class BasicGUI extends Application {
  @Override
  public void start(Stage primaryStage) {
	GridPane root = new GridPane();
    
	root.setHgap(10);
	root.setVgap(10);
	root.setPadding(new Insets(10, 10, 10, 10));

	final String[] UNITS = {"Celsius", "Fahrenheit", "Kelvin"};

	Label temperatureLabel = new Label("Temperature");
	TextField temperatureInput = new TextField();
	ComboBox<String> temperatureUnits = new ComboBox<String>();
	temperatureUnits.getItems().setAll(UNITS);
	temperatureUnits.setValue(UNITS[0]);
    
	Label convertedLabel = new Label("Converted");
	TextField convertedInput = new TextField();
	ComboBox<String> convertedUnits = new ComboBox<String>();
	convertedUnits.getItems().setAll(UNITS);
	convertedUnits.setValue(UNITS[1]);
	convertedInput.setEditable(false);
    
	Button convertButton = new Button("Convert");
	convertButton.setOnAction((event) -> {
  	String inTempString = temperatureInput.getText();
  	String inTempUnit = temperatureUnits.getValue();
  	String outTempUnit = convertedUnits.getValue();
  	String outTemp = convertTemperature(inTempString, inTempUnit,
                                      	outTempUnit);
  	if (outTemp != null) {
    	convertedInput.setText(outTemp);
  	} else {
    	convertedInput.setText("");
   	 
    	Alert alert = new Alert(Alert.AlertType.ERROR);
    	alert.setTitle("Invalid Temperature");
    	alert.setHeaderText(null);
    	alert.setContentText("You have entered an invalid "
                           	+ "temperature.");
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
    
	temperatureInput.setTextFormatter(new 
		TextFormatter<Double>(filter));

	root.add(temperatureLabel, 0, 0);
	root.add(temperatureInput, 1, 0);
	root.add(temperatureUnits, 2, 0);
    
	root.add(convertedLabel, 0, 1);
	root.add(convertedInput, 1, 1);
	root.add(convertedUnits, 2, 1);
    
	root.add(convertButton, 1, 2);
    
	Scene scene = new Scene(root);
    
	primaryStage.setTitle("Basic GUI");
	primaryStage.setScene(scene);
    
	primaryStage.sizeToScene();
    
	primaryStage.show();
  }
 
  private String convertTemperature(String inTempString,
                                	String inTempUnit,
                                	String outTempUnit) {
	try {
  	double in = Double.parseDouble(inTempString);
  	if (inTempUnit.equals(outTempUnit))
    	return inTempString;
 	 
  	if (inTempUnit.equals("Celsius")) {
    	if (outTempUnit.equals("Fahrenheit")) {
      	return String.valueOf(in * 1.8 + 32.0);
    	} else if (outTempUnit.equals("Kelvin")) {
      	return String.valueOf(in + 273.15);
    	}
  	} else if (inTempUnit.equals("Fahrenheit")) {
    	if (outTempUnit.equals("Celsius")) {
      	return String.valueOf((in - 32.0) / 1.8);
    	} else if (outTempUnit.equals("Kelvin")) {
      	return String.valueOf(((in - 32.0) / 1.8) + 273.15);
    	}
  	} else if (inTempUnit.equals("Kelvin")) {
    	if (outTempUnit.equals("Fahrenheit")) {
      	return String.valueOf(((in - 273.15) * 1.8) + 32.0);
    	} else if (outTempUnit.equals("Celsius")) {
      	return String.valueOf(in - 273.15);
    	}
  	}
	} catch (NumberFormatException ex) {}
    
	return null;
  }
 
  public static void main(String[] args) {
	launch(args);
  }
}

