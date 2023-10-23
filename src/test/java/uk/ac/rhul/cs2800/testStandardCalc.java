package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testStandardCalc {
	private StandardCalc calc;
	
	@BeforeEach
	void setup() {
		calc = new StandardCalc();
	}
	
	//Test 1
	// Ensure numerical output when expression submitted
	@Test
	void testAdd() throws InvalidExpressionException, BadTypeException {
		assertEquals(calc.evaluate("2 + 2"), 4);
	}
	
	// Test 2
	// Ensure minus operation works
	@Test
	void testMinus() throws InvalidExpressionException, BadTypeException {
		assertEquals(calc.evaluate("3 - 2"), 1);
	}
	
	// Test 3
	// Ensure multiplication operation works
	@Test
	void testMultiply() throws InvalidExpressionException, BadTypeException {
		assertEquals(calc.evaluate("2 * 2"),4 );
	}
	
	//Test 4
	// Ensure division operation works
	@Test
	void testDivision() throws InvalidExpressionException, BadTypeException {
		assertEquals(calc.evaluate("6 / 3"), 2);
	}
	
	//Test 5
	// Testing for harder calculations
	@Test
	void testCalculation() throws InvalidExpressionException, BadTypeException {
		assertEquals(calc.evaluate("5 + 5 * 10"), 55);
	}
	
	// Test 6
	@Test
	void umlExample() throws InvalidExpressionException, BadTypeException {
		assertEquals(calc.evaluate("( 5 * ( 6 + 7 ) ) - 2"), 63);
	}
	
}
