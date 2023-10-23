package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * This class creates a stack to store float values in form of Entry objects
 * 
 * @author Dilraaj Gill ZKAC282
 */
public class NumStack {
  /**
   * Creating the stack
   */
  private Stack numStack = new Stack();


  /**
   * Returns if the stack is empty or not
   */
  public boolean isEmpty() {
    return (numStack.size() == 0);
  }


  /**
   * Adds the float value to the end of the stack
   */
  public void push(float i) {
    numStack.push(new Entry(i));
  }

  /**
   * Removes and returns the item at the top of the stack
   */
  public float pop() {
    try {
      // Ensure stack is not empty
      if (isEmpty()) {
        throw new EmptyStackException();
      }
      // Return value if it contains one
      return (numStack.pop().getValue());
    } catch (BadTypeException e) {
      throw new EmptyStackException();
    }
  }

}
