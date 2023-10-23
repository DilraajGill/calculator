package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testOpStack {
	private OpStack stack;

	@BeforeEach
	void setup() {
		stack = new OpStack();
	}

	// Test 1
	// Check if the stack returns true if empty
	@Test
	void testEmpty() {
		assertTrue(stack.isEmpty());
	}

	// Test 2
	// Ensure the push operation is working
	@Test
	void testPush() {
		stack.push(Symbol.DIVIDE);
	}

	// Test 3
	// Make sure the pop() method returns and removes item at top of stack
	@Test
	void testPop() throws BadTypeException {
		stack.push(Symbol.DIVIDE);
		assertTrue(stack.pop() == Symbol.DIVIDE);
	}

	// Test 4
	// Ensure the isEmpty function does operates as intended
	@Test
	void testSize() {
		stack.push(Symbol.TIMES);
		assertFalse(stack.isEmpty());
	}

	// Test 5
	// Ensure the error is thrown when the operating on empty stack
	@Test
	void testError() {
		assertThrows(EmptyStackException.class, () -> stack.pop());
	}

}
