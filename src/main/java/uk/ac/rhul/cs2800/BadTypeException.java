package uk.ac.rhul.cs2800;

/**
 * Extends exception to be thrown when method has no return value
 * 
 * @author Dilraaj Gill ZKAC282
 */
public class BadTypeException extends Exception {
  /**
   * Constructor ran upon when this error has been thrown
   * 
   * @param error Parameter taken to return the message to be outputted
   */
  public BadTypeException(String error) {
    // Call the constructor of the super class
    super(error);
  }
}
