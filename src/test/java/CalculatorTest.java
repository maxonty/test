import org.example.Calculator;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {


    @Test
    void testSum() {
        assertEquals(7, Calculator.sum(3, 4));
    }

    @Test
    void testEven() {
        assertTrue(Calculator.isEven(6));
        assertFalse(Calculator.isEven(7));
    }

    @Test
    void testDivide() {
        assertAll(
                () -> assertEquals(5, Calculator.divide(10, 2)),
                () -> assertEquals(2, Calculator.divide(10, 5)),
                () -> assertEquals(4, Calculator.divide(20, 0))
                );

    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> Calculator.divide(10, 0));
    }

    @Test
    void testMultiply() {
        assertEquals(10, Calculator.multiply(5, 2));
        assertEquals(-10, Calculator.multiply(-5, 2));
    }
}
