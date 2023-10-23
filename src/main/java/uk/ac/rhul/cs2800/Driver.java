package uk.ac.rhul.cs2800;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * Driver class that initiates sequence to run JavaFX
 * 
 * @author Dilraaj Gill ZKAC282
 *
 */
public class Driver extends Application {
  // Controller to be used to control the calculator and communications
  private static CalcController controller = new CalcController();

  /**
   * Run the ASCII or GUI view depending on command line inputs. Aspects of this code were taken
   * from the CS2800 Examples (MVC-Separated)
   * 
   * @param args Arguments provided in command line
   */
  public static void main(String[] args) {
    // Launch either GUI or AsciiView
    if (System.console() == null) {
      launch(args);
    } else {
      // Add controller to AsciiView
      AsciiView ascii = new AsciiView();
      controller.addView(ascii);
      ascii.menu();
    }
  }

  /**
   * Create the interface of set dimensions with selected resources for design
   */
  @Override
  public void start(Stage primary) throws Exception {
    // Begin loading Gui MainView and add the necessary controller
    FXMLLoader paneLoad = new FXMLLoader(getClass().getClassLoader().getResource("MainView.fxml"));
    Scene scene = new Scene(paneLoad.load(), 500, 300);
    controller.addView(paneLoad.getController());
    primary.setScene(scene);
    primary.show();
  }

}
