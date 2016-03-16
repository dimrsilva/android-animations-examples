package com.animationsexamples;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PlayPauseActivity extends AppCompatActivity {

    private boolean shouldReverse;
    private ImageView imageView;
    private Button buttonToggle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_play_pause);

        shouldReverse = false;

        imageView = (ImageView) findViewById(R.id.image);
        buttonToggle = (Button) findViewById(R.id.button_toggle);

        buttonToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shouldReverse) {
                    imageView.setImageResource(R.drawable.play_pause_avd_reverse);
                } else {
                    imageView.setImageResource(R.drawable.play_pause_avd);
                }
                ((Animatable)imageView.getDrawable()).start();
                shouldReverse = !shouldReverse;
            }
        });
    }
}
