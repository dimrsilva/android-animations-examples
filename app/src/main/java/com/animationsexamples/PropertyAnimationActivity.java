package com.animationsexamples;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_property_animation);

        imageView = (ImageView) findViewById(R.id.image);
        buttonPlay = (Button) findViewById(R.id.button_play);
        buttonPause = (Button) findViewById(R.id.button_pause);
        buttonStop = (Button) findViewById(R.id.button_stop);

        final AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.rotation);
        set.setTarget(imageView);

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (set.isStarted() && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    set.resume();
                } else {
                    set.start();
                }
            }
        });

        buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    set.pause();
                } else {
                    set.cancel();
                }
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set.cancel();
            }
        });

    }
}
