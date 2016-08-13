package com.prabeesh.activitydemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();

    //region Final static variables
    private static final int REQ_CODE1 = 1;
    private static final int REQ_CAMERA = 2;
    //endregion

    //region Decelerations
    Button buttonLogin, buttonImage;
    EditText editTextUsername, editTextPassword;
    ImageView imageView;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Log.d(TAG, "onCreate() method");

        //region Initializations
        buttonLogin = (Button) findViewById(R.id.button_login);
        editTextUsername = (EditText) findViewById(R.id.edit_text_username);
        editTextPassword = (EditText) findViewById(R.id.edit_text_password);
        buttonImage = (Button) findViewById(R.id.button_image);
        imageView = (ImageView) findViewById(R.id.imageView);
        //endregion

        //region Image button click handling
        buttonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //intent.putExtra(MediaStore.EXTRA_SCREEN_ORIENTATION,
                startActivityForResult(intent, REQ_CAMERA);
            }
        });
        //endregion

        //region Login button click handling
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
        //endregion

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() method");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() method");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() method");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() method");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart() method");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() method");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQ_CODE1){
            if(resultCode == RESULT_OK){
                String receivedData = data.getExtras().getString("HTMLResult");
                String result = extractTextFromHtml(receivedData);
                Toast.makeText(LoginActivity.this, result, Toast.LENGTH_SHORT).show();
            } else if(resultCode == RESULT_CANCELED){
                Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }

        } else if(requestCode == REQ_CAMERA){
            //Write code to handle picture which was returned
            if (resultCode == RESULT_OK && data != null){
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(bitmap);
            } else {
                Toast.makeText(LoginActivity.this, "User cancelled camera operation", Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     *
     * @param htmlText Takes data in the form of a String with HTML text
     * @return Extracts all the string data from the html text excluding html tags
     */
    private String extractTextFromHtml(String htmlText) {

        StringBuilder stringBuilder = new StringBuilder(htmlText);

        while (stringBuilder.indexOf("<") != -1){
            stringBuilder.delete(stringBuilder.indexOf("<"),stringBuilder.indexOf(">")+1);
        }

        return stringBuilder.toString();
    }
}
