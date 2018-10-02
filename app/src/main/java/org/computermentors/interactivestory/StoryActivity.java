package org.computermentors.interactivestory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class StoryActivity extends AppCompatActivity {

    //Create a TAG for the log.
    public static final String TAG = StoryActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        //We created an intent which gets an intent passed from Main Activity.
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        //Add failsafe if the user does not put in a name.
        if(name == null || name.isEmpty()){
            name = "Friend";
        }

        //Logs the name we passed to the other activity in console below(Logcat).
        Log.d(TAG, name);
    }
}
