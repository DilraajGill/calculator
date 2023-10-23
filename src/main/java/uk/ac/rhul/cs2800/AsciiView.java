package uk.ac.rhul.cs2800;

import java.util.function.Consumer;
import java.util.Scanner;

/**
 * Create the ASCII interface as opposed to graphical
 * 
 * @author Dilraaj Gill ZKAC282
 */
public class AsciiView implements ViewInterface {
  // Initialise variables to be used as Observers
  Consumer<OpType> operationType = null;
  Runnable observer;
  String expression;

  /**
   * Display different commands available
   */
  public void instructions() {
    System.out.println("Commands Are:");
    System.out.println("E = Input Expression");
    System.out.println("C = Calculate");
    System.out.println("I = Infix Calculation");
    System.out.println("P = Postfix Calculation");
    System.out.println("Q = Exit\n");

  }

  /**
   * Return the user's question / expression
   */
  @Override
  public String getExpression() {
    return expression;
  }

  /**
   * Set the answer to be outputted by the interface
   * 
   * @param str Outputting the answer of the result
   */
  @Override
  public void setAnswer(String str) {
    System.out.println("Output: " + str);
  }

  /**
   * Add the calculator observer
   * 
   * @param calc Method to be ran when the calculator is to output an answer
   */
  @Override
  public void addCalcObserver(Runnable calc) {
    observer = calc;
  }

  /**
   * Add the type observer
   * 
   * @param c the OpType to be used
   */
  @Override
  public void addTypeObserver(Consumer<OpType> c) {
    operationType = c;
  }

  /**
   * The menu to be called to allow for inputs Aspects of this code were taken from CS2800 examples
   */
  public void menu() {
    Scanner kbd = new Scanner(System.in);
    instructions();
    boolean going = true;
    while (going && kbd.hasNext()) {
      // Check the user input and perform necessary procedure
      String input = kbd.nextLine();
      char letter = input.charAt(0);
      if (letter == 'E' || letter == 'e') {
        // Input expression
        System.out.println("Input Expression: ");
        expression = kbd.nextLine();
      } else if (letter == 'C' || letter == 'c') {
        // Return answer
        observer.run();
      } else if (letter == 'I' || letter == 'i') {
        // Change operation type to Infix
        if (operationType != null) {
          operationType.accept(OpType.INFIX);
        }
      } else if (letter == 'P' || letter == 'P') {
        // Change operating type to Postfix
        if (operationType != null) {
          operationType.accept(OpType.POSTFIX);
        }
      } else if (letter == 'Q' || letter == 'q') {
        going = false;
      }
    }
  }

}
