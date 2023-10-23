package uk.ac.rhul.cs2800;

/**
 * This Enum represents different types of symbols possible within a calculator
 * 
 * @author Dilraaj Gill ZKAC282
 */
public enum Symbol {
  /**
   * Different possible Symbols
   */
  // Possible symbols in a calculator
  LEFT_BRACKET, RIGHT_BRACKET, DIVIDE, TIMES, PLUS, MINUS, INVALID;

  /**
   * Returns the associated Enum in a printable format
   */
  @Override
  public String toString() {
    // Determine what the contents of the Enum are
    // Return in a printable format
    if (this.equals(DIVIDE)) {
      return ("Divide");
    } else if (this.equals(LEFT_BRACKET)) {
      return ("Left Bracket");
    } else if (this.equals(RIGHT_BRACKET)) {
      return ("Right Bracket");
    } else if (this.equals(TIMES)) {
      return ("Times");
    } else if (this.equals(PLUS)) {
      return ("Plus");
    } else if (this.equals(MINUS)) {
      return ("Minus");
    }
    return ("Invalid");
  }

  /**
   * Returns the symbol version of the Enum
   */
  public String toSymbol() {
    // Checks what value the Enum is equal to
    if (this.equals(DIVIDE)) {
      // Return the symbol equivalent
      return ("/");
    } else if (this.equals(LEFT_BRACKET)) {
      return ("(");
    } else if (this.equals(RIGHT_BRACKET)) {
      return (")");
    } else if (this.equals(TIMES)) {
      return ("*");
    } else if (this.equals(PLUS)) {
      return ("+");
    } else if (this.equals(MINUS)) {
      return ("-");
    }
    return ("Invalid");
  }
}
