package com.animationsexamples;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by anderson on 04/07/16.
 */

public class AnimatedVectorDrawableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_animated_vector_drawable);

        ImageView imageView = (ImageView) findViewById(R.id.image);
        ((Animatable)imageView.getDrawable()).start();

    }
}
