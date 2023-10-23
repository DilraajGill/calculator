package uk.ac.rhul.cs2800;

/**
 * This Enum represents the different possible inputs into a calculator
 * 
 * @author Dilraaj Gill ZKAC282
 */
public enum Type {
  /**
   * Different possible Types
   */
  // Different types of inputs to a calculator
  NUMBER, SYMBOL, STRING, INVALID;

  /**
   * Returns the associated Enum in a printable format
   */
  @Override
  public String toString() {
    // Determine contents of the Enum
    // Return this in a printable format
    if (this.equals(NUMBER)) {
      return ("Number");
    } else if (this.equals(SYMBOL)) {
      return ("Symbol");
    } else if (this.equals(STRING)) {
      return ("String");
    }
    return ("Invalid");
  }
}
