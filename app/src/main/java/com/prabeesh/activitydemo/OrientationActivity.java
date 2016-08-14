package com.prabeesh.activitydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OrientationActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation);

        editText = (EditText) findViewById(R.id.edit_text);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

    }

    public void onClick(View view) {
        button.setText("Logout");
        textView.setText("Testing text");
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        button.setText(savedInstanceState.getString("buttonText"));
        textView.setText(savedInstanceState.getString("textViewText"));
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("buttonText", button.getText().toString());
        outState.putString("textViewText", textView.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
