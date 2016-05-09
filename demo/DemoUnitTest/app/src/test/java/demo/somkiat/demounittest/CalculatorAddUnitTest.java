package demo.somkiat.demounittest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CalculatorAddUnitTest {
    private final int mOperandOne;
    private final int mOperandTwo;
    private final int mExpectedResult;

    private Calculator calculator = new Calculator();

    @Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {1, 2, 3},
                {2, 1, 3},
                {8, 2, 10},
                {-1, 6, 5},
        });
    }

    public CalculatorAddUnitTest(int mOperandOne,
                                 int mOperandTwo,
                                 int mExpectedResult) {
        this.mOperandOne = mOperandOne;
        this.mOperandTwo = mOperandTwo;
        this.mExpectedResult = mExpectedResult;
    }

    @Test
    public void addition_isCorrect(){
        assertEquals(this.mExpectedResult,
                calculator.add(this.mOperandOne, this.mOperandTwo), 0);
    }


}

