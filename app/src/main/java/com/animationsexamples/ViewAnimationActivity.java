package com.animationsexamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by andersonr on 17/04/16.
 */
public class ViewAnimationActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button buttonPlay;
    private Button buttonPlayAlpha;
    private Button buttonStop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_simple_rotate);

        imageView = (ImageView) findViewById(R.id.image);
        buttonPlay = (Button) findViewById(R.id.button_play);
        buttonPlayAlpha = (Button) findViewById(R.id.button_play_alpha);
        buttonStop = (Button) findViewById(R.id.button_stop);

        final Animation rotation = loadRotation();
        final Animation rotationAlpha = loadRotationAlpha();

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(rotation);
            }
        });

        buttonPlayAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(rotationAlpha);
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.clearAnimation();
            }
        });

    }

    private Animation loadRotation() {
        if (MainActivity.LOAD_PROGRAMATICALLY) {
            RotateAnimation rotate = new RotateAnimation(0, 720, Animation.RELATIVE_TO_SELF, .5f, Animation.RELATIVE_TO_SELF, .5f);
            rotate.setDuration(1500);
            rotate.setInterpolator(new LinearInterpolator());
            rotate.setRepeatCount(Animation.INFINITE);

            return rotate;
        } else {
            return AnimationUtils.loadAnimation(this, R.anim.rotation);
        }
    }

    private Animation loadRotationAlpha() {
        if (MainActivity.LOAD_PROGRAMATICALLY) {

            RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, .5f, Animation.RELATIVE_TO_SELF, .5f);
            rotate.setDuration(750);
            rotate.setInterpolator(new LinearInterpolator());
            rotate.setRepeatCount(Animation.INFINITE);

            AlphaAnimation alpha = new AlphaAnimation(1f, 0f);
            alpha.setDuration(250);
            alpha.setInterpolator(new AccelerateDecelerateInterpolator());
            alpha.setRepeatMode(Animation.REVERSE);
            alpha.setRepeatCount(Animation.INFINITE);

            AnimationSet animation = new AnimationSet(false);
            animation.addAnimation(rotate);
            animation.addAnimation(alpha);
            return animation;
        } else {
            return AnimationUtils.loadAnimation(this, R.anim.rotation_alpha);
        }
    }
}
