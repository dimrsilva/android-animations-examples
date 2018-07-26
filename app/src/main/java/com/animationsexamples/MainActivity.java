package com.animationsexamples;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final boolean LOAD_PROGRAMATICALLY = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        setupOnClickListener(R.id.button_view_animation, ViewAnimationActivity.class);
        setupOnClickListener(R.id.button_view_animation_translation, ViewAnimationTranslationActivity.class);
        setupOnClickListener(R.id.button_property_animation, PropertyAnimationActivity.class);
        setupOnClickListener(R.id.button_view_property_animator, ViewPropertyAnimatorActivity.class);
        setupOnClickListener(R.id.button_interpolator, InterpolatorsActivity.class);
        setupOnClickListener(R.id.button_layout_transition, LayoutTransitionActivity.class);
        setupOnClickListener(R.id.button_recycler_view, RecyclerViewAnimationActivity.class);
        findViewById(R.id.button_simple_transition).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SimpleTransitionActivity.class);
                Bundle options = ActivityOptions.makeCustomAnimation(MainActivity.this, R.anim.right_in, R.anim.left_out).toBundle();
                startActivity(intent, options);
            }
        });
        findViewById(R.id.button_scene_transition).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SceneTransitionActivity.class);
                ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        MainActivity.this,
                        findViewById(R.id.button_scene_transition),
                        getString(R.string.transition_button_scene)
                );
                ActivityCompat.startActivity(MainActivity.this, intent, activityOptions.toBundle());
            }
        });
        setupOnClickListener(R.id.button_animated_vector_drawable, AnimatedVectorDrawableActivity.class);
        setupOnClickListener(R.id.button_play_pause, PlayPauseActivity.class);
        setupOnClickListener(R.id.button_constraint_layout, ConstraintLayoutActivity.class);
    }

    private <T extends Activity> void setupOnClickListener(@IdRes int view, final Class<T> activityClass) {
        findViewById(view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(createIntent(activityClass));
            }
        });
    }

    private <T extends Activity> Intent createIntent(final Class<T> activityClass) {
        return new Intent(this, activityClass);
    }
}
