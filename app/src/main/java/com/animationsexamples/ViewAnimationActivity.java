package com.animationsexamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
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

        final Animation rotation = AnimationUtils.loadAnimation(this, R.anim.rotation);
        final Animation rotationAlpha = AnimationUtils.loadAnimation(this, R.anim.rotation_alpha);

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
}
