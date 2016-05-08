package demo.somkiat.demounittest;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorUnitTest {

    @Test
    public void addition_isCorrect() throws Exception {
        //Arrange
        Calculator calculator = new Calculator();
        //Act
        double actualResultOfAdd = calculator.add(1, 2);
        //Assert
        assertEquals(3, actualResultOfAdd, 0);
    }

    @Test
    public void subtraction_isCorrect() throws Exception {
        //Arrange
        Calculator calculator = new Calculator();
        //Act
        double actualResultOfAdd = calculator.sub(2, 1);
        //Assert
        assertEquals(1, actualResultOfAdd, 0);
    }
}