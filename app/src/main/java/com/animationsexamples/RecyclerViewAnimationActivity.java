package com.animationsexamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anderson on 10/07/16.
 */

public class RecyclerViewAnimationActivity extends AppCompatActivity {

    private Button buttonAddView;
    private RecyclerView recyclerView;

    private ExampleAdapter exampleAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recycler_view_animation);

        buttonAddView = (Button) findViewById(R.id.button_add_view);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        exampleAdapter = new ExampleAdapter();
        recyclerView.setAdapter(exampleAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setItemAnimator(new DefaultItemAnimator());

        buttonAddView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exampleAdapter.items.add(0, exampleAdapter.last++);
                exampleAdapter.notifyItemInserted(0);
            }
        });
    }

    private class ExampleAdapter extends RecyclerView.Adapter<ExampleViewHolder> {
        private int last = 20;
        private final List<Integer> items = new ArrayList<>();

        public ExampleAdapter() {
            for (int i = 0; i < last; i++) {
                items.add(i);
            }
        }

        @Override
        public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ExampleViewHolder(LayoutInflater.from(RecyclerViewAnimationActivity.this).inflate(R.layout.item_recycler_view, parent, false));
        }

        @Override
        public void onBindViewHolder(final ExampleViewHolder holder, final int position) {
            final Integer value = items.get(position);
            holder.text.setText(String.format("Item number %d", value));

            holder.text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int index = exampleAdapter.items.indexOf(value);
                    exampleAdapter.items.remove(index);
                    exampleAdapter.notifyItemRemoved(index);
                    holder.text.setOnClickListener(null);
                }
            });
        }

        @Override
        public int getItemCount() {
            return items.size();
        }
    }

    private class ExampleViewHolder extends RecyclerView.ViewHolder {
        private TextView text;

        public ExampleViewHolder(View itemView) {
            super(itemView);

            text = (TextView) itemView;
        }
    }
}
