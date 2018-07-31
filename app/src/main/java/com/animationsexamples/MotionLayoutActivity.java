package com.animationsexamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.motion.MotionLayout;
import android.support.constraint.motion.MotionScene;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;

public class MotionLayoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_motion_layout);

        final MotionLayout motionLayout = findViewById(R.id.motion_layout);
        final SeekBar seekBar = findViewById(R.id.seekbar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                float max = seekBar.getMax();
                float percentage = i / max;
                motionLayout.setProgress(percentage);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        findViewById(R.id.button_begin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                motionLayout.transitionToStart();
            }
        });

        findViewById(R.id.button_end).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                motionLayout.transitionToEnd();
            }
        });
    }
}
