package be.equality.diceroller

import kotlin.random.Random

class RandomRoller( private val min: Int , private val max : Int) {


    /**
     * Generates a number between [min] and [max]
     */
    fun roll(): Int {
        return Random.nextInt(max) + min
    }


}