package com.epsi.buget_manager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import android.os.Bundle;

public class AccountActivity extends AppCompatActivity {

    private Toolbar settingsToolbar;
    private TextView userEmail;
    private Button logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);


        settingsToolbar = findViewById(R.id.my_Feed_Toolbar);
        setSupportActionBar(settingsToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Mon Compte");

        logoutBtn = findViewById(R.id.logoutBtn);
        userEmail  = findViewById(R.id.userEmail);

        userEmail.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());


        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(AccountActivity.this)
                        .setTitle("Budget Manager")
                        .setMessage("Voulez-vous vraiment quitter?")
                        .setCancelable(false)
                        .setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                FirebaseAuth.getInstance().signOut();
                                Intent intent = new Intent(AccountActivity.this, LoginActivity.class);
                                startActivity( intent);
                                finish();
                            }
                        })
                        .setNegativeButton("Non", null)
                        .show();
            }
        });
    }



}