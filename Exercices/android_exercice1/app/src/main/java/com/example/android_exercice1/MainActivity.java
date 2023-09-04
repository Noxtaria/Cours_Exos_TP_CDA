package com.example.android_exercice1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNom;
    private EditText editTextPrenom;
    private EditText editTextTelephone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNom = findViewById(R.id.editTextNom);
        editTextPrenom = findViewById(R.id.editTextPrenom);
        editTextTelephone = findViewById(R.id.editTextTelephone);

        Button btnEnregistrer = findViewById(R.id.btnEnregistrer);
        btnEnregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom = editTextNom.getText().toString();
                String prenom = editTextPrenom.getText().toString();
                String telephone = editTextTelephone.getText().toString();

                DisplayContactFragment displayContactFragment = new DisplayContactFragment();
                Bundle bundle = new Bundle();
                bundle.putString("NOM", nom);
                bundle.putString("PRENOM", prenom);
                bundle.putString("TELEPHONE", telephone);
                displayContactFragment.setArguments(bundle);

                replaceFragment(displayContactFragment);
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
