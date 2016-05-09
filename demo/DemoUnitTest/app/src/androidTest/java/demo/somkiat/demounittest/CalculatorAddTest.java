package demo.somkiat.demounittest;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.test.suitebuilder.annotation.MediumTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class CalculatorAddTest {

    public static final String ONE = "1";
    public static final String TWO = "2";
    public static final String RESULT = "3.0";

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @MediumTest
    @Test
    public void calculatorAdd() {
        onView(withId(R.id.operand_one_edit_text)).perform(typeText(ONE));
        onView(withId(R.id.operand_two_edit_text)).perform(typeText(TWO));
        onView(withId(R.id.operation_add_button)).perform(click());
        onView(withId(R.id.operation_result_text_view)).check(matches(withText(RESULT)));
    }

    @LargeTest
    @Test
    public void calculatorAdd2() {
        onView(withId(R.id.operand_one_edit_text)).perform(typeText(ONE));
        onView(withId(R.id.operand_two_edit_text)).perform(typeText(TWO));
        onView(withId(R.id.operation_add_button)).perform(click());
        onView(withId(R.id.operation_result_text_view)).check(matches(withText(RESULT)));
    }

}
