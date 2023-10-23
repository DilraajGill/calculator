package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testNumStack {

  private NumStack stack;

  @BeforeEach
  void setup() {
    stack = new NumStack();
  }

  // Test 1
  // Check if the stack is empty
  @Test
  void testEmpty() {
    assertTrue(stack.isEmpty());
  }

  // Test 2
  // Add an item onto the stack created
  @Test
  void testPush() {
    stack.push((float) 5);
  }

  // Test 3
  // Remove the item at the top of the stack
  @Test
  void testPop() throws BadTypeException {
    stack.push((float) 5);
    assertTrue((float) 5 == stack.pop());
  }

  // Test 4
  // Check if size updates accordingly
  @Test
  void testSize() {
    stack.push((float) 2);
    assertFalse(stack.isEmpty());
  }

  // Test 5
  // Check if error has been thrown when popping empty list
  @Test
  void testErrorThrow() {
    assertThrows(EmptyStackException.class, () -> stack.pop());
  }
}
