package jp.ac.jec.cm0199.lottiejavasample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lottieAnimationView = findViewById(R.id.animationView);
    }

    @SuppressLint("NonConstantResourceId")
    public void onClickAction(View view) {
        final int viewId = view.getId();
        switch (viewId) {
            case R.id.playAnimationButton:
                lottieAnimationView.playAnimation();
                showToast("Call LottieAnimationView.playAnimation()");
                break;
            case R.id.resumeAnimationButton:
                lottieAnimationView.resumeAnimation();
                showToast("Call LottieAnimationView.resumeAnimation()");
                break;
            case R.id.cancelAnimationButton:
                lottieAnimationView.cancelAnimation();
                showToast("Call LottieAnimationView.cancelAnimation()");
                break;
            case R.id.pauseAnimationButton:
                lottieAnimationView.pauseAnimation();
                showToast("Call LottieAnimationView.pauseAnimation()");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + viewId);
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}