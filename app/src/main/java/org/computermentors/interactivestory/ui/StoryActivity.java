package org.computermentors.interactivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.computermentors.interactivestory.R;
import org.computermentors.interactivestory.model.Page;
import org.computermentors.interactivestory.model.Story;

public class StoryActivity extends AppCompatActivity {

    //Create a TAG for the log.
    public static final String TAG = StoryActivity.class.getSimpleName();

    private String name;
    private Story story;
    private ImageView storyImageView;
    private TextView storyTextView;
    private Button choice1Button;
    private Button choice2Button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        storyImageView = findViewById(R.id.storyImageView);
        storyTextView = findViewById(R.id.storyTextView);
        choice1Button = findViewById(R.id.choiceButton1);
        choice2Button = findViewById(R.id.choiceButton2);

        //We created an intent which gets an intent passed from Main Activity.
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        //Add failsafe if the user does not put in a name.
        if(name == null || name.isEmpty()){
            name = "Friend";
        }

        //Logs the name we passed to the other activity in console below(Logcat).
        Log.d(TAG, name);

        story = new Story();
        loadPage(0);
    }

    private void loadPage(int pageNumber){

        final Page page = story.getPage(pageNumber);

        Drawable image = ContextCompat.getDrawable(this, page.getImageId());
        storyImageView.setImageDrawable(image);

        String pageText = getString(page.getTextId());
        storyTextView.setText(pageText);

        if (page.isFinalPage()){
            choice1Button.setVisibility(View.INVISIBLE);
            choice2Button.setText(R.string.play_again_button_text);

        }

    }
}
