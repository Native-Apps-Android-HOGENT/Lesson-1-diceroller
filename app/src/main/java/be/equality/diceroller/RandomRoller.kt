package be.equality.diceroller

import kotlin.random.Random

class RandomRoller( val min: Int , val max : Int) {


    /**
     * Generates a number between [min] and [max]
     */
    fun roll(): Int {
        return Random.nextInt(max) + min;
    }


}