package com.example.shawaiz.realmurdu;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class ScoreboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        // variable intitalization
        String preference_filename = "realmurdu" ;

        String game1_correct = "game1CorrectKey";
        String game1_trial = "game1TrialKey";

        String game2_correct = "game2CorrectKey";
        String game2_trial = "game2TrialKey";

        // get handlers
        TextView game1_score = (TextView) findViewById(R.id.game_1_score);
        TextView game1_tries = (TextView) findViewById(R.id.game_1_tries);
        TextView game2_score = (TextView) findViewById(R.id.game_2_score);
        TextView game2_tries = (TextView) findViewById(R.id.game_2_tries);

        // update shared preference
        SharedPreferences sharedPreferences = getSharedPreferences(preference_filename, Context.MODE_PRIVATE);

        // set tags to updated vlaue
        game1_score.setText(Integer.toString(sharedPreferences.getInt(game1_correct, 0)));
        game1_tries.setText(Integer.toString(sharedPreferences.getInt(game1_trial, 0)));
        game2_score.setText(Integer.toString(sharedPreferences.getInt(game2_correct, 0)));
        game2_tries.setText(Integer.toString(sharedPreferences.getInt(game2_trial, 0)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scoreboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
