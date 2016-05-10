package demo.somkiat.workshopespresso;

import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import demo.somkiat.workshopespresso.NumberListviewActivity.Item;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;

@RunWith(AndroidJUnit4.class)
public class NumberListviewActivityTest {

    @Rule
    public ActivityTestRule<NumberListviewActivity> activityRule = new ActivityTestRule<>(NumberListviewActivity.class);

    @Test
    public void clickItem() {
        onView(withId(R.id.text))
                .check(matches(not(isDisplayed())));

        onData(withValue(20))
                .inAdapterView(withId(R.id.list))
                .perform(click());

        onView(withId(R.id.text))
                .check(matches(withText("20")))
                .check(matches(isDisplayed()));
    }



    public static Matcher<Object> withValue(final int value) {
        return new BoundedMatcher<Object, Item>(Item.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("has value " + value);
            }
            @Override
            public boolean matchesSafely(Item item) {
                return item.toString().equals(String.valueOf(value));
            }
        };
    }

}