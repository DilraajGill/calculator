package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testSymbol {
  // Test 1
  @Test
  // Returned fake expected value to pass the tests
  void testtoString() {
    assertEquals(Symbol.DIVIDE.toString(), "Divide");
  }

  // Test 2
  // Passed as a result of test 1 passing the fake expected value
  @Test
  void testFailToString() {
    assertFalse(Symbol.DIVIDE.toString() == "Plus");
  }

}
