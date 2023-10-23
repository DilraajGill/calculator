package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * Create a stack to store operations in the form of Entry objects
 * 
 * @author Dilraaj Gill ZKAC282
 */
public class OpStack {
  /**
   * Create the stack to store objects
   */
  private Stack opStack = new Stack();

  // Return if stack is empty
  public boolean isEmpty() {
    return (opStack.size() == 0);
  }

  /**
   * Adds the operation / Symbol to the top of the stack
   */
  // Add item if stack is empty
  public void push(Symbol s) {
    opStack.push(new Entry(s));
  }

  /**
   * Returns if the list is empty or not
   */
  // Remove item at the top of stack
  public Symbol pop() {
    try {
      if (this.isEmpty()) {
        throw new EmptyStackException();
      }
      return (opStack.pop().getSymbol());
    } catch (BadTypeException e) {
      throw new EmptyStackException();
    }
  }

  /**
   * Returns the item found at the top of the stack
   */
  // Return the item at the top of the stack
  public Symbol top() {
    try {
      return this.opStack.top().getSymbol();
    } catch (BadTypeException e) {
      throw new EmptyStackException();
    }
  }
}
