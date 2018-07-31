package com.animationsexamples;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;

public class ConstraintLayoutActivity extends AppCompatActivity {

    private ConstraintLayout constraintLayout;

    ConstraintSet initialConstraintSet;
    ConstraintSet finalConstraintSet;
    ConstraintSet nextConstraintSet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_constraint_layout);

        constraintLayout = findViewById(R.id.constraint_layout);

        initialConstraintSet = new ConstraintSet();
        initialConstraintSet.clone(constraintLayout);
        finalConstraintSet = new ConstraintSet();
        finalConstraintSet.clone(this, R.layout.activity_constraint_layout_final);
        nextConstraintSet = finalConstraintSet;

        findViewById(R.id.image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(constraintLayout);
                }
                nextConstraintSet.applyTo(constraintLayout);
                if (nextConstraintSet.equals(finalConstraintSet)) {
                    nextConstraintSet = initialConstraintSet;
                } else {
                    nextConstraintSet = finalConstraintSet;
                }
            }
        });
    }
}
