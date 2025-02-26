package com.example.myhomework_3;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    private ImageView heart;
    boolean active = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Spinner dropdown = findViewById(R.id.dropdown);
        String[] items = {"item 1", "item 2", "item 3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>( SecondActivity.this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(adapter);

        heart = findViewById(R.id.heart);
        heart.setOnClickListener(view -> {
            if (active) {
                heart.setImageResource(R.drawable.ic_heart);
            } else {
                heart.setImageResource(R.drawable.ic_active_heart);
            }
            active = !active;
        });
    }
}