package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testType {
  // Test 1
  // Returned fake expected value to pass the tests
  @Test
  void testToString() {
    assertEquals(Type.NUMBER.toString(), "Number");
  }

  // Test 2
  // Test was passed as a result of returning the correct value via faking test
  @Test
  void testFailToString() {
    assertFalse(Type.NUMBER.toString() == "Symbol");
  }

}
