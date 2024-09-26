package test.demo.parallel;

import static org.junit.jupiter.api.Assertions.*;

import demo.parallel.Complex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComplexTest {

    private Complex a;
    private Complex b;

    @BeforeEach
    void setUp() {
        a = new Complex(4.0, 2.0);
        b = new Complex(2.0, 1.0);
    }

    @Test
    void testDivide() {
        Complex result = a.divide(b);
        assertEquals(2.0, result.getRe(), 1e-10, "Real part should be 2.0");
        assertEquals(0.0, result.getIm(), 1e-10, "Imaginary part should be 0.0");
    }

    @Test
    void testDivideWithNegativeImaginary() {
        Complex c = new Complex(1.0, -1.0);
        Complex d = new Complex(1.0, 1.0);
        Complex result = c.divide(d);
        assertEquals(0.0, result.getRe(), 1e-10, "Real part should be 0.0");
        assertEquals(-1.0, result.getIm(), 1e-10, "Imaginary part should be -1.0");
    }

    @Test
    void testDivideWithLargeNumbers() {
        Complex largeA = new Complex(1000.0, 500.0);
        Complex largeB = new Complex(200.0, 100.0);
        Complex result = largeA.divide(largeB);
        assertEquals(5.0, result.getRe(), 1e-10, "Real part should be 5.0");
        assertEquals(0.0, result.getIm(), 1e-10, "Imaginary part should be 0.0");
    }
}