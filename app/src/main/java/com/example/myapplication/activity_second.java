package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class activity_second extends AppCompatActivity {

    public static final String EXTRA_REPLY =
            "com.example.myapplication.extra.REPLY";
    private static final String LOG_TAG = activity_second.class.getSimpleName();
    private EditText mReply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String herName = "";
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_message);
        if (savedInstanceState != null) {
            herName = savedInstanceState.getString("saved_comment");
            Log.d(LOG_TAG, "herName : " + herName);
        }else{
            Log.d(LOG_TAG, "savedInstanceState is null");
        }
        textView.setText(herName + " " + message);
        mReply = findViewById(R.id.editText_second);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        Bundle b = new Bundle();
//        TextView textView = findViewById(R.id.text_message);
//        String m = textView.getText().toString();
//        b.putString("saved_comment", m+"\n");
//        onSaveInstanceState(b);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView textView = findViewById(R.id.text_message);
        String m = textView.getText().toString();
        Log.d(LOG_TAG, "========================================");
        Log.d(LOG_TAG, "========================================");
        Log.d(LOG_TAG, "in on save instance" + m);
        Log.d(LOG_TAG, "========================================");
        Log.d(LOG_TAG, "========================================");
        outState.putString("saved_comment", m + "\n");
    }



    public void returnReply(View view) {
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        Log.d(LOG_TAG, "End SecondActivity");
        finish();
    }
}