package com.animationsexamples;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        setupOnClickListener(R.id.button_view_animation, ViewAnimationActivity.class);
        setupOnClickListener(R.id.button_view_animation_translation, ViewAnimationTranslationActivity.class);
        setupOnClickListener(R.id.button_property_animation, PropertyAnimationActivity.class);
        setupOnClickListener(R.id.button_view_property_animator, ViewPropertyAnimatorActivity.class);
        setupOnClickListener(R.id.button_play_pause, PlayPauseActivity.class);
    }

    private <T extends Activity> void setupOnClickListener(@IdRes int view, final Class<T> activityClass) {
        findViewById(view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, activityClass);
                startActivity(intent);
            }
        });
    }
}
