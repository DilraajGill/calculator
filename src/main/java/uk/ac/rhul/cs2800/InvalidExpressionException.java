package uk.ac.rhul.cs2800;

/**
 * Return exception when expression has no answer (invalid)
 * 
 * @author Dilraaj Gill ZKAC282
 */
public class InvalidExpressionException extends Exception {
  /**
   * Run super constructor with the error message provided
   */
  public InvalidExpressionException(String error) {
    super(error);
  }
}
