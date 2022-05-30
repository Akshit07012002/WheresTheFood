package com.example.wheresthefood.AuthPages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.wheresthefood.R;

public class MainActivity2 extends AppCompatActivity {

    Button toSignIn, toSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getSupportActionBar().hide();

        toSignUp = (Button) findViewById(R.id.toSignUp);
        toSignIn = (Button) findViewById(R.id.toSignIn);

        toSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this, SignInActivity.class));
            }
        });

        toSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this, SignUpActivity.class));
            }
        });
    }
}