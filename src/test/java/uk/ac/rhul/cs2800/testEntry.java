package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testEntry {
  private Entry test;

  @BeforeEach
  void setup() {
    test = new Entry(Symbol.TIMES);
  }

  // Test 1
  // To pass this test, I created the necessary constructors required to accept the arguments passed
  // Passed by construction
  @Test
  void testAllConstructors() {
    test = new Entry((float) 3.1516);
    test = new Entry("test string");
    test = new Entry(Symbol.PLUS);
  }

  // Test 2
  // Initially faked this test by returning the expected return (Type.SYMBOL)
  // Then coded the getType method to return the expected value
  @Test
  void testType() {
    assertEquals(test.getType(), Type.SYMBOL);
  }

  // Test 3
  // Faked this test by returning a Type Enum that was not Type.NUMBER
  // After coding the method, this test was passed (as object had Type Type.SYMBOL)
  @Test
  void testFailType() {
    assertFalse(test.getType() == Type.NUMBER);
  }

  // Test 4
  // This was passed initially by returning the expected Enum to pass the test through faking
  // Once getSymbol() was coded, this test passed as Symbol.TIMES is what the instance was
  // constructed with
  @Test
  void testSymbol() throws BadTypeException {
    assertEquals(test.getSymbol(), Symbol.TIMES);
  }

  // Test 5
  // This was passed by returning the expected float to pass the test by faking
  @Test
  void testNumber() throws BadTypeException {
    test = new Entry((float) 5.25);
    assertEquals(test.getValue(), (float) 5.25);
  }


  // Test 6
  // This was passed by returning the expected string to pass the test by faking
  @Test
  void testString() throws BadTypeException {
    test = new Entry("Test String");
    assertEquals(test.getString(), "Test String");
  }

  // Test 7
  // Ensuring the code was working correctly by testing if it would return False too
  @Test
  void testFailSymbol() throws BadTypeException {
    assertFalse(test.getSymbol() == Symbol.DIVIDE);
  }

  // Test 8
  // Started off faking this test by developing method to throw BadTypeException straight away
  // Developed my code to check the value of the object and then return the value (or error)
  @Test
  void testFailException() throws BadTypeException {
    assertThrows(BadTypeException.class, () -> test.getValue());
  }

  // Test 9
  // Made equals() method return the expected value created in BeforeEach call
  // Utilised previous getters to compare if equal
  @Test
  void testEquals() {
    Entry compare = new Entry(Symbol.TIMES);
    assertTrue(test.equals(compare));
  }

  // Test 10
  // Created afterwards to ensure the method was operating as intended and catch bugs
  @Test
  void testNotEqual() {
    Entry compare = new Entry(Symbol.DIVIDE);
    assertFalse(test.equals(compare));
  }

  // Test 11
  // Originally coded toString() to output "Symbol: Times" to fake the test
  // Began developing toString by using getType() method that was created from previous tests
  @Test
  void testToString() {
    assertEquals(test.toString(), "Symbol: Times");
  }
}
