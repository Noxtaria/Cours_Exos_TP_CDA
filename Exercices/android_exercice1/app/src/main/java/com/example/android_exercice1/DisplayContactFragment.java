package com.example.android_exercice1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DisplayContactFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display_contact, container, false);

        Bundle bundle = getArguments();
        if (bundle != null) {
            String nom = bundle.getString("NOM");
            String prenom = bundle.getString("PRENOM");
            String telephone = bundle.getString("TELEPHONE");

            TextView textViewNom = view.findViewById(R.id.textViewNom);
            TextView textViewPrenom = view.findViewById(R.id.textViewPrenom);
            TextView textViewTelephone = view.findViewById(R.id.textViewTelephone);

            textViewNom.setText("Nom: " + nom);
            textViewPrenom.setText("Prénom: " + prenom);
            textViewTelephone.setText("Téléphone: " + telephone);
        }

        return view;
    }
}
