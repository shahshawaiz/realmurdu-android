package com.example.shawaiz.realmurdu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
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

    // Intent calls functions

    public void callActivityLanguage(View v){

        Intent i = new Intent(this, UpdateLangActivity.class);
        startActivity(i);
    }

    public void callScoreboard(View v){

        // variable intitalization
        String preference_filename = "realmurdu" ;

        String game1_correct = "game1CorrectKey";
        String game1_trial = "game1TrialKey";

        String game2_correct = "game2CorrectKey";
        String game2_trial = "game2TrialKey";

        //Set the initialized to TRUE
        SharedPreferences.Editor editor = getSharedPreferences(preference_filename, Context.MODE_PRIVATE).edit();


        editor.putInt(game1_correct, 0);
        editor.putInt(game1_trial, 0);

        editor.putInt(game2_correct, 0);
        editor.putInt(game2_trial, 0);

        editor.commit();

        Toast.makeText(this, R.string.score_reseted, Toast.LENGTH_SHORT).show();

    }
}
