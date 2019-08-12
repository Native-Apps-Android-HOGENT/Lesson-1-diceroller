package be.equality.diceroller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        roll_button.text = "Let's Roll"
        roll_button.setOnClickListener {
            Log.i("MainAxtivity", "Rolled")
            Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
        }



    }
}
