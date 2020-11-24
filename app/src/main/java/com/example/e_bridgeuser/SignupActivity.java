package com.example.e_bridgeuser;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    Button login;
    Button signup;
    EditText pass, user, email, uniRoll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        /*
        login=(Button)findViewById(R.id.login);

        signup=(Button)findViewById(R.id.signup);
        pass=(EditText)findViewById(R.id.pass);
        uniRoll=(EditText)findViewById(R.id.uniRoll);
        user=(EditText)findViewById(R.id.user);
        email=(EditText)findViewById(R.id.email);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
            }
        });
    }

    private void check(){
        if (pass.getText().toString().isEmpty() || email.getText().toString().isEmpty()||uniRoll.getText().toString().isEmpty()||user.getText().toString().isEmpty() ){
            Toast.makeText(this, "Enter Details Correctly", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Registered Sucessfully!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(),Dashboard.class);
            startActivity(intent);
        }*/
    }
}
