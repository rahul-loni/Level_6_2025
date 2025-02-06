package com.example.otp_auth;

import android.content.Intent;
import android.os.Bundle;
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

public class Signup_Page extends AppCompatActivity {

    EditText email,password,cPassword;
    Button signup_btn;
    TextView login_txt;


    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup_page);

        email=findViewById(R.id.txt_email);
        password=findViewById(R.id.txt_password);
        cPassword=findViewById(R.id.txt_Cpassword);
        signup_btn=findViewById(R.id.register_btn);
        login_txt=findViewById(R.id.txt_login);

        auth=FirebaseAuth.getInstance();

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email=email.getText().toString().trim();
                String Password=password.getText().toString().trim();
                String CPassword=cPassword.getText().toString().trim();

                if (Email.isEmpty()){
                    Toast.makeText(Signup_Page.this, "Please Enter Email First", Toast.LENGTH_SHORT).show();
                }
                if (Password.isEmpty()){
                    Toast.makeText(Signup_Page.this, "Please Enter Password First", Toast.LENGTH_SHORT).show();
                }
                if (password.length()>6){
                    Toast.makeText(Signup_Page.this, "Password Is too short", Toast.LENGTH_SHORT).show();
                }
                if (password.equals(CPassword)){
                    auth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Intent intent=new Intent(Signup_Page.this,MainActivity.class);
                            startActivity(intent);
                            Toast.makeText(Signup_Page.this, "Signup is complete ", Toast.LENGTH_SHORT).show();
                            finish();

                        }else {
                            Toast.makeText(Signup_Page.this, "Something error ", Toast.LENGTH_SHORT).show();
                        }
                        }
                    });
                }

            }
        });
    }
}