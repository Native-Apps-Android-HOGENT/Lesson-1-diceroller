package be.equality.diceroller

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.VectorDrawable
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

/**
 * Apache 2.0
 *
 * @see [Source1][https://github.com/stablekernel/EspressoLib/blob/master/src/main/java/com/stablekernel/espressolib/DrawableMatcher.java]
 *
 * @see [Source2][http://stackoverflow.com/questions/33696488/getting-bitmap-from-vector-drawable]
 *
 * Convenient class which checks that the drawable has a non-null value of a specific type.
 */
class DrawableMatcher(@param:DrawableRes private val expectedResourceId: Int) :
    TypeSafeMatcher<View>(View::class.java) {

    override fun matchesSafely(item: View): Boolean {
        if (item !is ImageView) return false

        if (expectedResourceId == 0) return item.drawable == null

        val expectedDrawable = ContextCompat.getDrawable(item.getContext(), expectedResourceId)
            ?: return false

        val actualDrawable = item.drawable

        if (expectedDrawable is VectorDrawable) {
            return if (actualDrawable !is VectorDrawable) false else vectorToBitmap(expectedDrawable).sameAs(
                vectorToBitmap(actualDrawable)
            )
        }

        if (expectedDrawable is BitmapDrawable) {
            return if (actualDrawable !is BitmapDrawable) false else expectedDrawable.bitmap.sameAs(
                actualDrawable.bitmap
            )
        }

        throw IllegalArgumentException("Unsupported drawable: " + item.drawable)
    }

    private fun vectorToBitmap(vectorDrawable: VectorDrawable): Bitmap {
        val bitmap = Bitmap.createBitmap(
            vectorDrawable.intrinsicWidth,
            vectorDrawable.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        vectorDrawable.setBounds(0, 0, canvas.width, canvas.height)
        vectorDrawable.draw(canvas)
        return bitmap
    }

    override fun describeTo(description: Description) {
        description.appendText("with drawable id: ").appendValue(expectedResourceId)
    }
}