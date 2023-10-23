package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testCalcModel {
  CalcModel calculator = CalcModel.getInstance();

  // Test to ensure the INFIX calculator is working
  @Test
  void testPolish() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("5 + 5", true), 10);
  }

  // Test to ensure the POSTFIX calculator is working
  @Test
  void testStandard() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("5 5 +", false), 10);
  }

  // Testing to ensure challenging expressions also work as intended
  @Test
  void testHardPolish() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("( 5 / 5 ) * 10", true), 10);
  }

  // Testing to ensure challenging expressions also work as intended
  @Test
  void testHardInfix() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("5 5 / 10 *", false), 10);
  }

}
