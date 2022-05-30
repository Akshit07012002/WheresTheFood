package com.example.wheresthefood.AuthPages;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wheresthefood.R;

import com.example.wheresthefood.DatabaseHelpers.AuthDBHelper;

public class SignUpActivity extends AppCompatActivity {

    EditText username, password, repassword;
    Button signUp, signIn;

    AuthDBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);

        signUp = (Button) findViewById(R.id.buttonSignUp);
        //signIn = (Button) findViewById(R.id.buttonSignIn);

        DB = new AuthDBHelper(this);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(SignUpActivity.this, "Field(s) Cannot Be Empty", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkUsername(user);
                        if(checkuser == false){
                            Boolean insert = DB.insertData(user,pass);
                            if(insert == true)
                            {
                                Toast.makeText(SignUpActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), SignInActivity.class));
                            }
                            else
                                Toast.makeText(SignUpActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(SignUpActivity.this, "User Already Exists. Sign In.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}