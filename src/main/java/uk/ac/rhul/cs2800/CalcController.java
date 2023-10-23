package uk.ac.rhul.cs2800;

/**
 * Control the calculators to allow communication between CalcModel and ViewInterface
 * 
 * @author Dilraaj Gill ZKAC282
 */
public class CalcController {
  // Get singleton CalcModel by calling upon the static instance
  private CalcModel model = CalcModel.getInstance();
  private ViewInterface view;
  private boolean isInfix = true;

  // Return the value of the input expression
  /**
   * Returns the value of the expression. If invalid, output error message to ViewInterface
   */
  private void calculate() {
    try {
      view.setAnswer(Float.toString(model.evaluate(view.getExpression(), isInfix)));
      // Return invalid if it is incorrect
    } catch (InvalidExpressionException e) {
      view.setAnswer("Invalid Expression");
    }
  }

  /**
   * Change the operation method between Infix and Postfix
   * 
   * @param operation The new operation type
   */
  private void expressionType(OpType operation) {
    // Change operation method
    if (operation.equals(OpType.INFIX)) {
      isInfix = true;
      view.setAnswer("Calculator changed to INFIX method");
    } else {
      view.setAnswer("Calculator changed to POSTFIX method");
      isInfix = false;
    }
  }

  /**
   * Add view interface and update the observers accordingly Aspects of this code were taken from
   * the CS2800 Examples (MVC-Separated)
   * 
   * @param calcView The new ViewInterface being used
   */
  public void addView(ViewInterface calcView) {
    // Add the observers and update the view
    view = calcView;
    calcView.addCalcObserver(this::calculate);
    calcView.addTypeObserver(this::expressionType);
  }
}
