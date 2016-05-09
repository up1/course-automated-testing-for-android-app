package demo.somkiat.demounittest;

import android.test.suitebuilder.annotation.LargeTest;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorUnitTest {
    Calculator calculator = new Calculator();

    @SmallTest
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(3, calculator.add(1, 2), 0);
    }

    @MediumTest
    @Test
    public void subtraction_isCorrect() throws Exception {
        assertEquals(1, calculator.sub(2, 1), 0);
    }

    @LargeTest
    @Test
    public void divide_isCorrect() throws Exception {
        assertEquals(2, calculator.div(2, 1), 0);
    }
}