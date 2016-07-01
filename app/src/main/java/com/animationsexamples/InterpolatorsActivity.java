package com.animationsexamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;

/**
 * Created by anderson on 26/06/16.
 */

public class InterpolatorsActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_interpolators);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button.getTranslationY() == 0) {
                    int bottom = findViewById(android.R.id.content).getHeight() - button.getBottom();
                    button.animate()
                            .translationY(bottom)
                            .setInterpolator(new BounceInterpolator())
                            .setDuration(750);
                } else {
                    button.animate()
                            .translationY(0)
                            .setInterpolator(new OvershootInterpolator())
                            .setDuration(750);
                }
            }
        });
    }
}
