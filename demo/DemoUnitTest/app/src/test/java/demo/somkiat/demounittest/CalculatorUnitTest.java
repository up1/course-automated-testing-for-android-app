package demo.somkiat.demounittest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorUnitTest {
    Calculator calculator = new Calculator();

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(3, calculator.add(1, 2), 0);
        assertEquals(3, calculator.add(2, 1), 0);
        assertEquals(10, calculator.add(8, 2), 0);
        assertEquals(5, calculator.add(-1, 6), 0);
    }

    @Test
    public void subtraction_isCorrect() throws Exception {
        assertEquals(1, calculator.sub(2, 1), 0);
    }

    @Test
    public void divide_isCorrect() throws Exception {
        assertEquals(2, calculator.div(2, 1), 0);
    }
}