package com.animationsexamples;

import android.os.Bundle;
import android.support.animation.DynamicAnimation;
import android.support.animation.SpringAnimation;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;

public class SpringAnimationActivity extends AppCompatActivity {

    private float yDistance;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_spring_layout);

        yDistance = getResources().getDimension(R.dimen.spring_y_distance);

        final View framelayout = findViewById(R.id.framelayout);
        final View view1 = findViewById(R.id.view1);
        final View view2 = findViewById(R.id.view2);
        final View view3 = findViewById(R.id.view3);
        final SeekBar stifness = findViewById(R.id.stifness);
        final SeekBar dampingRatio = findViewById(R.id.dampingRatio);

        final SpringAnimation animX1 = createSpringAnimation(view1, SpringAnimation.X);
        final SpringAnimation animY1 = createSpringAnimation(view1, SpringAnimation.Y);
        final SpringAnimation animX2 = createSpringAnimation(view2, SpringAnimation.X);
        final SpringAnimation animY2 = createSpringAnimation(view2, SpringAnimation.Y);
        final SpringAnimation animX3 = createSpringAnimation(view3, SpringAnimation.X);
        final SpringAnimation animY3 = createSpringAnimation(view3, SpringAnimation.Y);

        framelayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_MOVE:
                    case MotionEvent.ACTION_UP:
                        animX1.animateToFinalPosition(motionEvent.getRawX());
                        animY1.animateToFinalPosition(motionEvent.getRawY());

                        return true;
                }
                return false;
            }
        });

        animX1.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() {
            @Override
            public void onAnimationUpdate(DynamicAnimation animation, float value, float velocity) {
                animX2.animateToFinalPosition(value);
            }
        });

        animY1.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() {
            @Override
            public void onAnimationUpdate(DynamicAnimation animation, float value, float velocity) {
                animY2.animateToFinalPosition(value + yDistance);
            }
        });

        animX2.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() {
            @Override
            public void onAnimationUpdate(DynamicAnimation animation, float value, float velocity) {
                animX3.animateToFinalPosition(value);
            }
        });

        animY2.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() {
            @Override
            public void onAnimationUpdate(DynamicAnimation animation, float value, float velocity) {
                animY3.animateToFinalPosition(value + yDistance);
            }
        });

        stifness.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int stifness = (int) (((float) i / seekBar.getMax()) * 10000);
                animX1.getSpring().setStiffness(stifness);
                animY1.getSpring().setStiffness(stifness);
                animX2.getSpring().setStiffness(stifness);
                animY2.getSpring().setStiffness(stifness);
                animX3.getSpring().setStiffness(stifness);
                animY3.getSpring().setStiffness(stifness);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        dampingRatio.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                float dampingRatio = (float) i / seekBar.getMax();
                animX1.getSpring().setDampingRatio(dampingRatio);
                animY1.getSpring().setDampingRatio(dampingRatio);
                animX2.getSpring().setDampingRatio(dampingRatio);
                animY2.getSpring().setDampingRatio(dampingRatio);
                animX3.getSpring().setDampingRatio(dampingRatio);
                animY3.getSpring().setDampingRatio(dampingRatio);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private SpringAnimation createSpringAnimation(View view, DynamicAnimation.ViewProperty property) {
        SpringAnimation animation = new SpringAnimation(view, property, 0);
        return animation;
    }
}
