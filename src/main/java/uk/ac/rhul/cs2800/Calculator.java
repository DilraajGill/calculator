package uk.ac.rhul.cs2800;

/**
 * Interface to be implemented by calculation methods
 * 
 * @author Dilraaj Gill ZKAC282
 */
public interface Calculator {

  /**
   * Abstract method to return value of expression
   */
  public float evaluate(String what) throws InvalidExpressionException;
}
