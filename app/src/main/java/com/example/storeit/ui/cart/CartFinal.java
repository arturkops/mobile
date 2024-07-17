package com.example.storeit.ui.cart;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.example.storeit.R;

import com.example.storeit.R;
import com.example.storeit.ui.home.HomeFragment;

public class CartFinal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Button buttonBack = findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar para o HomeFragment na MainActivity
                Intent intent = new Intent(CartFinal.this, HomeFragment.class);
                intent.putExtra("FRAGMENT_TO_OPEN", "HOME");
                startActivity(intent);
                finish();
            }
        });

    }
}