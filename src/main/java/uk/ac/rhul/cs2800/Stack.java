package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;


/**
 * This class creates a stack containing Entry objects
 * 
 * @author Dilraaj Gill ZKAC282
 */
public class Stack {
  /**
   * Creating the list storing Entry objects
   */
  private List<Entry> entries = new ArrayList<Entry>();

  /**
   * This method adds Entry object to the stack
   * 
   * @param item Entry to be added
   */
  public void push(Entry item) {
    // Add item to the end of the list
    this.entries.add(item);
  }

  /**
   * Returns and removes the Entry object at top of the stack
   * 
   */
  public Entry pop() {
    // Check if list is empty
    if (this.size() == 0) {
      // Throw exception if empty
      throw new EmptyStackException();
    }
    // Remove and return the item at the top of stack
    Entry item = this.entries.remove(this.entries.size() - 1);
    return item;
  }

  /**
   * Returns the size of the stack
   */
  public int size() {
    return this.entries.size();
  }

  /**
   * Returns the Entry object at top of the stack
   */
  public Entry top() {
    // Check if list is empty
    if (this.size() == 0) {
      // Throw exception if empty
      throw new EmptyStackException();
    }
    // Return item at the top of the stack
    return (this.entries.get(this.entries.size() - 1));
  }
}
