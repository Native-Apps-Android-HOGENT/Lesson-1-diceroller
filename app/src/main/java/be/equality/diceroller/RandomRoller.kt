package be.equality.diceroller

class RandomRoller(private val min: Int, private val max: Int) {

    /**
     * Generates a number between [min] and [max]
     */
    fun roll(): Int {
        return (min..max).random()
    }

}