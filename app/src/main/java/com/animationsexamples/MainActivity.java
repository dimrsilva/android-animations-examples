package com.animationsexamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonViewAnimation;
    private Button buttonPropertyAnimation;
    private Button buttonPlayPause;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        buttonViewAnimation = (Button) findViewById(R.id.button_view_animation);
        buttonPropertyAnimation = (Button) findViewById(R.id.button_property_animation);
        buttonPlayPause = (Button) findViewById(R.id.button_play_pause);

        buttonViewAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewAnimationActivity.class);
                startActivity(intent);
            }
        });

        buttonPropertyAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PropertyAnimationActivity.class);
                startActivity(intent);
            }
        });

        buttonPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlayPauseActivity.class);
                startActivity(intent);
            }
        });
    }
}
