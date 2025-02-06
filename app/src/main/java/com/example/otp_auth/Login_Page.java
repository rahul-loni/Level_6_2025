package com.example.otp_auth;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Page extends AppCompatActivity {
     EditText email,password;
     Button btnLogin;
     TextView register_txt;
     FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_page);

        email=findViewById(R.id.txt_email);
        password=findViewById(R.id.txt_password);
        btnLogin=findViewById(R.id.login_btn);
        register_txt=findViewById(R.id.register_btn);

        auth=FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email=email.getText().toString().trim();
                String Password=password.getText().toString().trim();
                if (Email.isEmpty()){
                    Toast.makeText(Login_Page.this, "Please Enter Email first", Toast.LENGTH_SHORT).show();
                }
                if (Password.isEmpty()){
                    Toast.makeText(Login_Page.this, "Please Enter Password ", Toast.LENGTH_SHORT).show();
                }else {
                    auth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Intent intent=new Intent(Login_Page.this,MainActivity.class);
                                startActivity(intent);
                                Toast.makeText(Login_Page.this, "Login complete", Toast.LENGTH_SHORT).show();
                                finish();
                            }else {
                                Toast.makeText(Login_Page.this, "Login is not complete ", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });



    }
}