package be.equality.diceroller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    private val randomRoller = RandomRoller(1,6)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        roll_button.text = getString(R.string.lets_roll)
        roll_button.setOnClickListener {
            rollDice()
            Timber.i("Pressed the button")
        }



    }

    /**
     * Generates a random integer and assigns its value to the TextView.
     */
    private fun rollDice() {
        val drawableResource = when (randomRoller.roll()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        dice_image.setImageResource(drawableResource)
    }
}
