package com.example.smartattendance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class facultyactivity extends AppCompatActivity {
    public EditText collegeId, password;
    Button btnlogin;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facultyactivity);

        mFirebaseAuth = FirebaseAuth.getInstance();
        collegeId = findViewById(R.id.collegeid);
        password = findViewById(R.id.password);
        btnlogin = findViewById(R.id.login);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String college = collegeId.getText().toString();
                String pwd = password.getText().toString();
                if (college.isEmpty()) {
                    collegeId.setError("Please enter college id");
                    collegeId.requestFocus();
                } else if (pwd.isEmpty()) {
                    password.setError("please enter your password");
                    password.requestFocus();
                } else if (college.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(facultyactivity.this, "Fields are empty!", Toast.LENGTH_SHORT).show();
                } else if (!(college.isEmpty() && pwd.isEmpty())) {
                    mFirebaseAuth.signInWithEmailAndPassword(college, pwd)
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    Toast.makeText(facultyactivity.this, "Welcome user!", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(facultyactivity.this, faculty_next.class));
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(facultyactivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    Toast.makeText(facultyactivity.this, "Error Occurred!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void loggedin(View view) {

        Intent intent = new Intent(this, faculty_next.class);
        startActivity(intent);
    }
}