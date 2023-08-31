package com.example.form_2_activites;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button buttonSave = findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = ((EditText) findViewById(R.id.editTextFirstName)).getText().toString();
                String lastName = ((EditText) findViewById(R.id.editTextLastName)).getText().toString();
                String phoneNumber = ((EditText) findViewById(R.id.editTextPhoneNumber)).getText().toString();

                Intent intent = new Intent(MainActivity.this, DisplayContactActivity.class);
                intent.putExtra("first_name", firstName);
                intent.putExtra("last_name", lastName);
                intent.putExtra("phone_number", phoneNumber);
                startActivity(intent);
            }
        });

    }
}