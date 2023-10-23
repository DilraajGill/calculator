package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * Reverse Polish Calculator to calculate POSTFIX expressions
 * 
 * @author Dilraaj Gill ZKAC282
 */
public class RevPolishCalc implements Calculator {
  // Create a NumStack to store numbers
  private NumStack values = new NumStack();

  /**
   * Override abstract method to evaluate expression and return answer
   * 
   * @param what The postfix expression to be evaluated
   * @throws InvalidExpressionException This is thrown whenever the inputted expression has a
   *         mistake
   */
  @Override
  public float evaluate(String what) throws InvalidExpressionException {
    while (!(values.isEmpty())) {
      values.pop();
    }
    // Split expression based on white space
    String[] list = what.split(" ");
    // Traverse through the String array created
    for (String i : list) {
      try {
        values.push(Float.parseFloat(i));
      } catch (NumberFormatException e) {
        try {
          // If it is a symbol, pop two values and perform expression
          float numOne = values.pop();
          float numTwo = values.pop();
          if (i.equals("*")) {
            values.push(numOne * numTwo);
          } else if (i.equals("-")) {
            values.push(numTwo - numOne);
          } else if (i.equals("/")) {
            values.push(numTwo / numOne);
          } else if (i.equals("+")) {
            values.push(numTwo + numOne);
          }
        } catch (EmptyStackException e1) {
          throw new InvalidExpressionException("This expression is not valid!");
        }
      }
    }
    // Ensure the bug is corrected
    float answer = values.pop();
    if (!(values.isEmpty())) {
      throw new InvalidExpressionException("This expression is not valid");
    }
    return answer;
  }
}
