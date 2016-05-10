package demo.somkiat.workshopespresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;

@RunWith(AndroidJUnit4.class)
public class HelloActivityTest {

    @Rule
    public ActivityTestRule<HelloActivity> activityRule = new ActivityTestRule<>(
            HelloActivity.class);

    @Test
    public void greet() {
        onView(withId(R.id.greeting))
                .check(matches(withText("")));

        onView(withId(R.id.greet_button))
                .check(matches(withText(R.string.greet)))
                .perform(click());

        onView(withId(R.id.greeting))
                .check(matches(withText(R.string.hello)));
    }

    @Test
    public void disable() {
        onView(withId(R.id.state_button))
                .check(matches(isEnabled()));

        onView(withId(R.id.state_button))
                .check(matches(withText(R.string.disable)))
                .perform(click());

        onView(withId(R.id.state_button))
                .check(matches(not(isEnabled())));
    }

}