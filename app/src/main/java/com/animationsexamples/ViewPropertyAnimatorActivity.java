package com.animationsexamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by anderson on 26/06/16.
 */

public class ViewPropertyAnimatorActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_property_animator);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setRotation(0);
                button.setAlpha(1);
                button.animate()
                        .alpha(0.5f)
                        .rotation(360)
                        .setDuration(750);
            }
        });
    }
}
