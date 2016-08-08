package com.prabeesh.activitydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private static final int REQ_CODE1 = 1;
    private static final int REQ_CAMERA = 2;

    // Deceleration
    Button buttonLogin;
    EditText editTextUsername, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialization
        buttonLogin = (Button) findViewById(R.id.button_login);
        editTextUsername = (EditText) findViewById(R.id.edit_text_username);
        editTextPassword = (EditText) findViewById(R.id.edit_text_password);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();
                if(username.isEmpty() || password.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Username or password empty!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    intent.putExtra("uname", username);
                    intent.putExtra("pass", password);
                    startActivityForResult(intent, REQ_CODE1);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQ_CODE1){
            if(resultCode == RESULT_OK){
                String receivedData = data.getExtras().getString("DataReturned");
                Toast.makeText(LoginActivity.this, receivedData, Toast.LENGTH_SHORT).show();
            } else if(resultCode == RESULT_CANCELED){
                Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }

        } else if(requestCode == REQ_CAMERA){
            //Write code to handle picture which was returned
        }
    }
}
