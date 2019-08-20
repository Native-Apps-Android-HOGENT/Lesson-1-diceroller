package be.equality.diceroller



import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId

import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class PressButtonTest {

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    /**
     * This test presses the button of the Dice Roller and checks
     * that the imageView is still visible for the user.
     */
    @Test
    fun pressButton(){
        onView(withId(R.id.roll_button))
        onView(withId(R.id.dice_image)).check(matches(isDisplayed()))
    }

}