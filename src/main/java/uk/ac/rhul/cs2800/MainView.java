package uk.ac.rhul.cs2800;

import java.util.function.Consumer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;

/**
 * Design layout of the GUI
 * 
 * @author Dilraaj Gill ZKAC282
 */
public class MainView implements ViewInterface {

  @FXML
  private Button calculate;
  /**
   * Label describing where to type expression
   */
  @FXML
  private Label expression;
  /**
   * Main window for the interface
   */
  @FXML
  private Pane mainPane;
  /**
   * Label to hold the result value
   */
  @FXML
  private Label result;

  /**
   * Radio button to determine postfix or infix method
   */
  @FXML
  private RadioButton reverse;

  /**
   * Toggle group for the radio buttons
   */
  @FXML
  private ToggleGroup calcMethod;

  /**
   * TextField for user to input their expression
   */
  @FXML
  private TextField userExpression;

  /**
   * Get the text from the GUI
   */
  @Override
  public String getExpression() {
    return (userExpression.getText());
  }

  /**
   * Set the value of the answer text field to the str
   * 
   * @param str Value to set the text field to
   */
  @Override
  public void setAnswer(String str) {
    result.setText(str);
  }

  /**
   * Add the type observer to change between Postfix and Infix. Aspects of this code were taken from
   * the CS2800 Examples (MVC-Separated)
   * 
   * @param c the variable observer to update
   */
  @Override
  public void addTypeObserver(Consumer<OpType> c) {
    calcMethod.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
      public void changed(ObservableValue<? extends Toggle> observable, Toggle from, Toggle to) {
        c.accept(to == reverse ? OpType.POSTFIX : OpType.INFIX);
      }
    });
  }

  /**
   * Add the calculator observer Aspects of this code were taken from the CS2800 Examples
   * (MVC-Separated)
   * 
   * @param calc Run this method upon when the event needs to be handled
   */
  @Override
  public void addCalcObserver(Runnable calc) {
    calculate.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent event) {
        calc.run();
      }
    });
  }


}
