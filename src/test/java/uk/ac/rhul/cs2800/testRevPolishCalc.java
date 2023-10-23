package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testRevPolishCalc {
  RevPolishCalc calculator;

  @BeforeEach
  void setup() {
    calculator = new RevPolishCalc();
  }

  // Test 1
  // Ensure evaluate will return numerical value when only a numerical value has been inputted
  // Faked to return the expected value
  @Test
  void test() throws InvalidExpressionException, BadTypeException {
    assertTrue(calculator.evaluate("10") == 10);
  }

  // Test 2
  // Ensure plus operations now work
  // Realised from the previous commit I had written it down wrong when faking
  @Test
  void testOperationPlus() throws InvalidExpressionException, BadTypeException {
    assertTrue(calculator.evaluate("9 1 +") == 10);
  }

  // Test 3
  // Ensure minus operations now work
  @Test
  void testOperationMinus() throws InvalidExpressionException, BadTypeException {
    assertTrue(calculator.evaluate("9 1 -") == 8);
  }

  // Test 4
  // Ensure division operations now work
  @Test
  void testOperationDivide() throws InvalidExpressionException, BadTypeException {
    assertTrue(calculator.evaluate("9 1 /") == 9);
  }

  // Test 5
  // Ensure multiplication operations now work
  @Test
  void testOperationMultiply() throws InvalidExpressionException, BadTypeException {
    assertTrue(calculator.evaluate("9 1 *") == 9);
  }

  // Test 6
  // Ensure all operations can work together
  @Test
  void testExample() throws InvalidExpressionException, BadTypeException {
    assertTrue(calculator.evaluate("5 6 7 + * 2 -") == 63);
  }

  // Test 7
  // Error should be thrown when invalid expression is submitted
  @Test
  void testInvalidExpression() {
    assertThrows(InvalidExpressionException.class, () -> calculator.evaluate("9 + 10"));
  }
}
