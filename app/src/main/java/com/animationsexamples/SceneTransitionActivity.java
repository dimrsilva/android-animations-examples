package com.animationsexamples;

import android.app.ActivityOptions;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.AutoTransition;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by anderson on 03/07/16.
 */

public class SceneTransitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_scene_transition);

        findViewById(R.id.button_scene_transition).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                supportFinishAfterTransition();
            }
        });

        final LinearLayout linearLayout = findViewById(R.id.linearlayout);
        View buttonAddMargin = findViewById(R.id.button_add_margin);
        final View buttonRemoveMargin = findViewById(R.id.button_remove_margin);

        buttonAddMargin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setMargin(linearLayout, buttonRemoveMargin, getResources().getDimensionPixelOffset(R.dimen.spring_y_distance));
            }
        });

        buttonRemoveMargin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setMargin(linearLayout, buttonRemoveMargin, 0);
            }
        });
    }

    private void setMargin(LinearLayout linearLayout, View buttonRemoveMargin, int margin) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) buttonRemoveMargin.getLayoutParams();
            lp.topMargin = margin;
            buttonRemoveMargin.requestLayout();
            TransitionManager.beginDelayedTransition(linearLayout);
        }
    }
}
