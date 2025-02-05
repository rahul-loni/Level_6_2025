package com.example.otp_auth;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Signup_Page extends AppCompatActivity {

    EditText email,password,cPassword;
    Button signup_btn;
    TextView login_txt;

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
    }
}