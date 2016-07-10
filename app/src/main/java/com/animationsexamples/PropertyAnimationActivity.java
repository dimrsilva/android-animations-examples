package com.animationsexamples;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by andersonr on 19/04/16.
 */
public class PropertyAnimationActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button buttonPlay;
    private Button buttonPause;
    private Button buttonStop;
    private Button buttonAnimateButtons;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_property_animation);

        imageView = (ImageView) findViewById(R.id.image);
        buttonPlay = (Button) findViewById(R.id.button_play);
        buttonPause = (Button) findViewById(R.id.button_pause);
        buttonStop = (Button) findViewById(R.id.button_stop);
        buttonAnimateButtons = (Button) findViewById(R.id.button_animate_buttons);

        final Animator animator = AnimatorInflater.loadAnimator(this, R.animator.rotation);
        animator.setTarget(imageView);

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (animator.isStarted() && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    animator.resume();
                } else {
                    animator.start();
                }
            }
        });

        buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    animator.pause();
                } else {
                    animator.cancel();
                }
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animator.cancel();
            }
        });

        final Animator animatorButtonPlay = ObjectAnimator.ofFloat(buttonPlay, View.ROTATION, 360);
        final Animator animatorButtonPause = ObjectAnimator.ofFloat(buttonPause, View.TRANSLATION_Y, 40);
        final ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);

        final ArgbEvaluator argbEvaluator = new ArgbEvaluator();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int colorStart = ContextCompat.getColor(PropertyAnimationActivity.this, R.color.colorAccent);
                int colorEnd = ContextCompat.getColor(PropertyAnimationActivity.this, R.color.colorPrimary);
                buttonStop.setTextColor((Integer) argbEvaluator.evaluate(animation.getAnimatedFraction(), colorStart, colorEnd));
            }
        });

        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(1000);
        animatorSet.play(animatorButtonPlay).with(animatorButtonPause).with(valueAnimator);

        buttonAnimateButtons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animatorSet.start();
            }
        });

    }

    private Animator loadAnimator() {
        if (MainActivity.LOAD_PROGRAMATICALLY) {
            ObjectAnimator rotation = ObjectAnimator.ofFloat(null, View.ROTATION, 0, 360);
            rotation.setInterpolator(new LinearInterpolator());
            rotation.setRepeatCount(ObjectAnimator.INFINITE);
            rotation.setDuration(1500);

            ObjectAnimator alpha = ObjectAnimator.ofFloat(null, View.ALPHA, 1, 0);
            alpha.setInterpolator(new AccelerateDecelerateInterpolator());
            alpha.setRepeatCount(ObjectAnimator.INFINITE);
            alpha.setRepeatMode(ObjectAnimator.REVERSE);
            alpha.setDuration(500);

            AnimatorSet animator = new AnimatorSet();
            animator.play(rotation).with(alpha);
            return animator;
        } else {
            return AnimatorInflater.loadAnimator(this, R.animator.rotation);
        }
    }
}
