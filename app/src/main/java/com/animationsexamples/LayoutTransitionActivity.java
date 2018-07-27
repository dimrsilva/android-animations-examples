package com.animationsexamples;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by anderson on 30/06/16.
 */

public class LayoutTransitionActivity extends AppCompatActivity {

    private ViewGroup layout;
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_layout_transition);

        layout = (ViewGroup) findViewById(R.id.layout);
        button = (Button) findViewById(R.id.button_add_view);

        LayoutTransition layoutTransition = layout.getLayoutTransition();
        layoutTransition.setAnimator(LayoutTransition.APPEARING, AnimatorInflater.loadAnimator(this, R.animator.scale_up));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            layout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View view = LayoutInflater.from(layout.getContext()).inflate(R.layout.item_layout_transition, layout, false);
                view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        View image = view.findViewById(R.id.image);
                        if (image.isShown()) {
                            image.setVisibility(View.GONE);
                        } else {
                            image.setVisibility(View.VISIBLE);
                        }
                    }
                });
                view.findViewById(R.id.button_delete).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        layout.removeView(view);
                    }
                });
                layout.addView(view, 1);
            }
        });
    }
}
