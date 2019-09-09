package be.equality.diceroller


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class PressButtonTest {

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun initial_emptyDiceVisible() {
        onView(withId(R.id.dice_image)).check(matches(DrawableMatcher(R.drawable.empty_dice)))
    }

    @Test
    fun pressButton_newDiceShown() {
        onView(withId(R.id.roll_button)).perform(click())
        onView(withId(R.id.dice_image)).check(matches(not(DrawableMatcher(R.drawable.empty_dice))))
    }

}