package com.example.form_2_activites;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact);

        Intent intent = getIntent();
        String firstName = intent.getStringExtra("first_name");
        String lastName = intent.getStringExtra("last_name");
        String phoneNumber = intent.getStringExtra("phone_number");

        TextView textViewFullName = findViewById(R.id.textViewFullName);
        TextView textViewPhoneNumber = findViewById(R.id.textViewPhoneNumber);

        textViewFullName.setText(firstName + " " + lastName);
        textViewPhoneNumber.setText(phoneNumber);
    }
}
