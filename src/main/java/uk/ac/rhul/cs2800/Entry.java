package uk.ac.rhul.cs2800;

import java.util.Objects;

/**
 * This class stores entries submitted into calculator
 * 
 * @author Dilraaj Gill ZKAC282
 */
public class Entry {

  /**
   * Initialising attributes of the object
   */
  private float number;
  private Symbol other;
  private String str;
  private Type type = Type.INVALID;

  /**
   * Constructor that stores the float and updates type accordingly
   * 
   * @param value A float entered into the calculator in which operations are to be performed with
   */
  public Entry(float value) {
    this.number = value;
    this.type = Type.NUMBER;
  }

  /**
   * Constructor that stores the Symbol and updates type accordingly
   * 
   * @param which A Symbol Enum entered into the calculator to signify which symbol / operation to
   *        execute
   */
  public Entry(Symbol which) {
    this.other = which;
    this.type = Type.SYMBOL;
  }

  /**
   * Constructor that stores the String and updates type accordingly
   * 
   * @param line A string variable entered into the calculator
   */
  public Entry(String line) {
    this.str = line;
    this.type = Type.STRING;
  }

  /**
   * Returns the Type enum
   */
  public Type getType() {
    return this.type;
  }

  /**
   * Returns String value (str) if it has a compatible value
   * 
   * @throws BadTypeException If String value is not stored in the object, this error is thrown
   */
  public String getString() throws BadTypeException {
    if (this.getType() != Type.STRING) {
      // Thrown exception because there is no String variable stored by constructor
      throw new BadTypeException("Incorrect Data Type");
    }
    return this.str;
  }

  /**
   * Returns Symbol value (other) if it has a compatible value
   * 
   * @throws BadTypeException If Symbol is not stored in the object, this error is thrown
   */
  public Symbol getSymbol() throws BadTypeException {
    if (this.getType() != Type.SYMBOL) {
      // Thrown exception because there is no Symbol variable stored by constructor
      throw new BadTypeException("Incorrect Data Type");
    }
    return this.other;
  }

  /**
   * Returns float value (number) if it has a compatible value
   * 
   * @throws BadTypeException If float is not stored in the object, this error is thrown
   */
  public float getValue() throws BadTypeException {
    if (this.getType() != Type.NUMBER) {
      // Thrown exception because there is no float variable stored by constructor
      throw new BadTypeException("Incorrect Data Type");
    }
    return this.number;
  }

  /**
   * Returns if two objects are equal in attributes
   */
  public boolean equals(Object comparison) {
    // Check if parameter is an Entry object
    if (!(comparison instanceof Entry)) {
      return false;
    }
    Entry compare = (Entry) comparison;
    try {
      // Determine what value is held by the object
      if (this.getType() == compare.getType()) {
        Type same = this.getType();
        // Check if these values are equal
        if (same == Type.NUMBER) {
          return (this.getValue() == compare.getValue());
        } else if (same == Type.STRING) {
          return (this.getString() == compare.getString());
        } else if (same == Type.SYMBOL) {
          return (this.getSymbol() == compare.getSymbol());
        }
      }
    } catch (BadTypeException b) {
      System.out.println(b);
    }
    return false;
  }

  /**
   * Generate a hashcode based on the value of the attributes being stored
   */
  @Override
  public int hashCode() {
    // Generated based on the value inputted and data type
    return Objects.hash(number, other, str, type);
  }

  /**
   * Returns the attribute and it's value being stored in the object
   */
  @Override
  public String toString() {
    // Determine what type of data was stored
    // From this, return the data type stored and it's contents
    if (this.getType() == Type.NUMBER) {
      return (this.getType().toString() + ": " + this.number);
    } else if (this.getType() == Type.STRING) {
      return (this.getType().toString() + ": " + this.str);
    } else if (this.getType() == Type.SYMBOL) {
      return (this.getType().toString() + ": " + this.other.toString());
    }
    return (this.getType().toString());
  }
}
