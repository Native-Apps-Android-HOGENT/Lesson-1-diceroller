package be.equality.diceroller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        roll_button.text = "Let's Roll"
        roll_button.setOnClickListener {
            rollDice()
        }



    }

    /**
     * Generates a random integer and assigns its value to the TextView.
     */
    private fun rollDice() {
        val randomInt = Random().nextInt(6) + 1
        result_text.text = randomInt.toString()
    }
}
