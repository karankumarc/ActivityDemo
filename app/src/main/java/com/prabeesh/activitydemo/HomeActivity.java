package com.prabeesh.activitydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    TextView textViewWelcomeMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textViewWelcomeMessage = (TextView) findViewById(R.id.text_view_welcome_message);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        String username = bundle.getString("uname");
        String password = bundle.getString("pass");

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
}
