package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testStack {
  private Stack test;

  @BeforeEach
  void setup() {
    test = new Stack();
  }

  // Test 1
  // This test passed by faking my method returning value to be 0
  @Test
  void testSize() {
    assertEquals(test.size(), 0);
  }

  // Test 2
  // Code passed without any issues as no returns required
  @Test
  void testAdd() {
    test.push(new Entry(Symbol.DIVIDE));
  }

  // Test 3
  // Originally failed as size method only returned 0
  // Coded push add to stack and then used the inbuilt arraylist .size function to pass
  @Test
  void testAddSize() {
    test.push(new Entry(Symbol.DIVIDE));
    test.push(new Entry("test string"));
    assertEquals(test.size(), 2);
  }

  // Test 4
  // This test passed by faking the .pop() method to return the Entry object expected
  @Test
  void testRemove() {
    Entry match = new Entry(Symbol.DIVIDE);
    test.push(match);
    assertEquals(test.pop(), match);
  }

  // Test 5
  // Made .top() return the expected fake value to pass this test
  @Test
  void testTop() {
    Entry match = new Entry(Symbol.DIVIDE);
    test.push(match);
    assertEquals(test.top(), match);
  }

  // Test 6
  // Developed top() method further to return value at the top of stack based on .size()
  @Test
  void testEmptyTop() {
    assertThrows(EmptyStackException.class, () -> test.top());
  }

  // Test 7
  // Developed pop() method further to return value at the top of stack based on the index
  @Test
  void testEmptyPop() {
    assertThrows(EmptyStackException.class, () -> test.pop());
  }

  // Test 8
  // Ensuring size is updated accordingly when stack is being added to and removed
  @Test
  void testPushPopSize() {
    Entry testEntry = new Entry(Symbol.DIVIDE);
    test.push(testEntry);
    assertEquals(test.size(), 1);
    assertEquals(test.pop(), testEntry);
    assertEquals(test.size(), 0);
  }

  // Test 9
  // Ensuring that the code can handle multiple pushes and update size
  // Began with ensuring push updates size
  // Developed to popping the list to empty it and ensuring size updates
  @Test
  void pushLots() {
    int i = 0;
    while (test.size() < 10) {
      test.push(new Entry("Test String"));
      i++;
      assertEquals(test.size(), i);
    }
    while (test.size() > 0) {
      test.pop();
      i--;
      assertEquals(test.size(), i);
    }
  }
}
