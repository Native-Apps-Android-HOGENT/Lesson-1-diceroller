package be.equality.diceroller

import org.junit.Assert
import org.junit.Test

class RandomRollerTest {


    /**
     * Tests whether the [RandomRoller] generates numbers between the given integers.
     */
    @Test
    fun testRoller(){
        var rRoller = RandomRoller(1,6)

        for (x in 1 .. 10){
            var number = rRoller.roll()
            Assert.assertTrue("Number is too high", number <= 6)
            Assert.assertTrue("Number is too low", number >= 1)
        }
    }
}