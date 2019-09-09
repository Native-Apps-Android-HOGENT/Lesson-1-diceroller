package be.equality.diceroller

import org.junit.Assert
import org.junit.Test

class RandomRollerTest {


    /**
     * Tests whether the [RandomRoller] generates numbers between the given integers.
     */
    @Test
    fun testRoller() {
        val rRoller = RandomRoller(1, 6)

        repeat(100) {
            val number = rRoller.roll()
            Assert.assertTrue(
                "RandomRoller generated a number outside of the specified range.",
                (1..6).contains(number)
            )
        }
    }
}