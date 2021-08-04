package jp.ac.jec.cm0199.lottiekotlinsample

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickAction(view: View) {
        val lottieAnimationView: LottieAnimationView = findViewById(R.id.animationView)
        when (val viewId = view.id) {
            R.id.playAnimationButton -> {
                lottieAnimationView.playAnimation()
                showToast("Call LottieAnimationView.playAnimation()")
            }
            R.id.resumeAnimationButton -> {
                lottieAnimationView.resumeAnimation()
                showToast("Call LottieAnimationView.resumeAnimation()")
            }
            R.id.cancelAnimationButton -> {
                lottieAnimationView.cancelAnimation()
                showToast("Call LottieAnimationView.cancelAnimation()")
            }
            R.id.pauseAnimationButton -> {
                lottieAnimationView.pauseAnimation()
                showToast("Call LottieAnimationView.pauseAnimation()")
            }
            else -> throw IllegalStateException("Unexpected value: $viewId")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}