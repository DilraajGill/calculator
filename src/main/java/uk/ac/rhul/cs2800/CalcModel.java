package uk.ac.rhul.cs2800;

/**
 * Class to process INFIX and POSTFIX operations
 * 
 * @author Dilraaj Gill ZKAC282
 */
public final class CalcModel {
  // Design the class as a Singleton
  private static CalcModel model;
  private Calculator postfix = new RevPolishCalc();
  private Calculator infix = new StandardCalc();

  /**
   * @param string The expression to be calculated
   * @param b Boolean stands for whether it is postfix or infix operation
   * @throws InvalidExpressionException Expression is not valid
   */
  // Return the value of the outcome of expression
  public float evaluate(String string, boolean b) throws InvalidExpressionException {
    // Run the correct calculator depending on calculation type
    if (b == true) {
      return infix.evaluate(string);
    }
    return (postfix.evaluate(string));
  }

  /**
   * Returns the singleton existence or create one if it does not exist
   */
  public static CalcModel getInstance() {
    // Return the singleton instance if it exists
    if (model == null) {
      model = new CalcModel();
    }
    return model;
  }

}
