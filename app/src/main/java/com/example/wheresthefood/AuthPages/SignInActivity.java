package com.example.wheresthefood.AuthPages;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wheresthefood.MainActivity;
import com.example.wheresthefood.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wheresthefood.DatabaseHelpers.AuthDBHelper;
import com.example.wheresthefood.DatabaseHelpers.DBHelper;

public class SignInActivity extends AppCompatActivity {

    EditText user, pass;
    Button signIn;

    AuthDBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        user = (EditText) findViewById(R.id.username1);
        pass = (EditText) findViewById(R.id.password1);
        signIn = (Button) findViewById(R.id.buttonSignIn);

        DB = new AuthDBHelper(this);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = user.getText().toString();
                String password = pass.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(SignInActivity.this, "Field(s) Cannot Be Empty", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkUserPass = DB.checkUsernamePassword(username, password);
                    if(checkUserPass == true)
                    {
                        Toast.makeText(SignInActivity.this, "Signed In Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }
                    else
                        Toast.makeText(SignInActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}