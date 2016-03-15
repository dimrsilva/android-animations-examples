package com.animationsexamples;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PlayPauseActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button buttonToggle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_play_pause);

        imageView = (ImageView) findViewById(R.id.image);
        buttonToggle = (Button) findViewById(R.id.button_toggle);

        buttonToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animatable drawable = (Animatable) imageView.getDrawable();
                if (drawable.isRunning()) {
                    drawable.stop();
                } else {
                    drawable.start();
                }
            }
        });
    }
}
