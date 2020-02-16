package com.example.mytestapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button submitButton;

    EditText companyNameText, jobPositionText, locationText, statusText, appliedOnText, lastDateText, notesText;

    JobEntry jobEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitButton = findViewById(R.id.submit_button);

        jobEntry = new JobEntry();

        companyNameText = findViewById(R.id.companyNameText);
        jobPositionText = findViewById(R.id.jobPositionText);
        locationText = findViewById(R.id.locationText);
        statusText = findViewById(R.id.statusText);
        appliedOnText = findViewById(R.id.appliedOnText);
        lastDateText = findViewById(R.id.lastDateText);
        notesText = findViewById(R.id.notesText);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cnText = companyNameText.getText().toString();
                String jpText = jobPositionText.getText().toString();
                String lText = locationText.getText().toString();
                String sText = statusText.getText().toString();
                String aoText = appliedOnText.getText().toString();
                String ldText = lastDateText.getText().toString();
                String nText = notesText.getText().toString();

                if (cnText == null)
                    jobEntry.setCompanyName("");
                else
                    jobEntry.setCompanyName(cnText);

                if (jpText == null)
                    jobEntry.setJobPosition("");
                else
                    jobEntry.setJobPosition(jpText);

                if (lText == null)
                    jobEntry.setLocation("");
                else
                    jobEntry.setLocation(lText);

                if (sText == null)
                    jobEntry.setStatus("");
                else
                    jobEntry.setStatus(sText);

                if (aoText == null)
                    jobEntry.setAppliedOn("");
                else
                    jobEntry.setAppliedOn(aoText);

                if (ldText == null)
                    jobEntry.setLastDate("");
                else
                    jobEntry.setLastDate(ldText);

                if (nText == null)
                    jobEntry.setNotes("");
                else
                    jobEntry.setNotes(nText);

                Log.d("JobEntry", jobEntry.toString());
            }
        });

    }

    @Override
    public void onClick(View v) {

    }
}
