package com.prabeesh.activitydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private static final String HTML_RESULT = "<html> <title> Welcome\n</title> " +
            "<h1>Transaction Deatails\n</h1><body> Transaction status:Success!\n " +
            "Currency:1000INR Mode:Paypal\n</body> " +
            "</html>";

    private static final String TAG = HomeActivity.class.getSimpleName();

    TextView textViewWelcomeMessage;

    Button buttonSuccess, buttonFailure;

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Log.d(TAG, "onCreate() method");

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        String username = bundle.getString("uname");
        String password = bundle.getString("pass");


        textViewWelcomeMessage = (TextView) findViewById(R.id.text_view_welcome_message);
        buttonSuccess = (Button) findViewById(R.id.button_success);
        buttonFailure = (Button) findViewById(R.id.button_failure);

        editText = (EditText) findViewById(R.id.edit_text);

        buttonSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("HTMLResult",HTML_RESULT);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        buttonFailure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });


        textViewWelcomeMessage.setText("Welcome "+username);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean handled= false;
        switch (item.getItemId()){
            case R.id.action_settings:
                Toast.makeText(HomeActivity.this, "Settings clicked", Toast.LENGTH_SHORT).show();
                handled = true;
                break;
            case R.id.action_quit:
                handled = true;
                finish();
                break;
        }
        return handled;
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
}
