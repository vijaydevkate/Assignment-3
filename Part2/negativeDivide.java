package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testDivideByZero {

	@Test
	public void testDivideByZero() {
		JunitTesting test = new JunitTesting();
		try {
	         double result = test.divide(10.0, 0.0);
	         fail("Expected ArithmeticException not thrown");
	      } catch (ArithmeticException e) {
	         assertEquals("/ by zero", e.getMessage());
	      }
	}


}