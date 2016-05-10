package demo.somkiat.workshopespresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;

@RunWith(AndroidJUnit4.class)
public class ListviewWithScrollbarActivityTest {


    @Rule
    public ActivityTestRule<ListviewWithScrollbarActivity> activityTestRule
            = new ActivityTestRule<>(ListviewWithScrollbarActivity.class);

    @Test
    public void toDoListTest(){

        onData(anything())
                .inAdapterView(withId(R.id.list_of_todos)).atPosition(20)
                .perform(click());

        onView(withId(R.id.txt_selected_item))
                .check(matches(withText("Latest")));
    }

}
