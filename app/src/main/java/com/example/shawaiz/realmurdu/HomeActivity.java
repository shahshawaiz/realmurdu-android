package com.example.shawaiz.realmurdu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.Locale;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.initiatepreferences();
        this.updateLanguage();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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


    // shared preferences initialization
    public void initiatepreferences(){


//        // Check if the application has been initialized
//        // Retrieve the object sharedPreference of the application
//        SharedPreferences savedSession = activity.getSharedPreferences(MyLightConstants.KEY, Context.MODE_PRIVATE);
//        // Retrieve the initiliazed attribute (if the key is not found, this call returns FALSE)
//        initialized = savedSession.getBoolean(INITIALIZED, Boolean.FALSE);
//        //When launching for the first time the application, initialized==FALSE
//        if (!initialized) {
//            //Set the initialized to TRUE
//            Editor editor = activity.getSharedPreferences(KEY, Context.MODE_PRIVATE).edit();
//            editor.putBoolean(INITIALIZED, Boolean.TRUE);
//            editor.commit();
//            //And do your initilisation actions:
//            an action
//        }

        // variable intitalization
        String preference_filename = "realmurdu" ;

        String initialized_status = "false";

        String language = "languageKey";

        String game1_correct = "game1CorrectKey";
        String game1_trial = "game1TrialKey";

        String game2_correct = "game2CorrectKey";
        String game2_trial = "game2TrialKey";

        // check if preferences are initialized
        SharedPreferences sharedPreferences = getSharedPreferences(preference_filename, Context.MODE_PRIVATE);
        Boolean check_initliazation = sharedPreferences.getBoolean(initialized_status, Boolean.FALSE);

        //When launching for the first time the application, initialized==FALSE
        if (check_initliazation == Boolean.FALSE) {

            //Set the initialized to TRUE
            SharedPreferences.Editor editor = getSharedPreferences(preference_filename, Context.MODE_PRIVATE).edit();

            // initialize values
            editor.putBoolean(initialized_status, Boolean.TRUE);

            editor.putInt(language, 1); //1=English ; 2=Urdu; 3=Frech; 4=Espanol; 5=Hindi

            editor.putInt(game1_correct, 0);
            editor.putInt(game1_trial, 0);

            editor.putInt(game2_correct, 0);
            editor.putInt(game2_trial, 0);

            editor.commit();
        }

    }

    // Intent call functions

    public void callActivityPlay(View v){

        Intent i = new Intent(this, AvailableGamesActivity.class);
        startActivity(i);
    }

    public void callActivityScorecard(View v){

        Intent i = new Intent(this, ScoreboardActivity.class);
        startActivity(i);
    }

    public void callActivitySettings(View v){

        Intent i = new Intent(this, SettingsActivity.class);
        startActivity(i);
    }

    public void callActivityFeedback(View v){

        Intent i = new Intent(this, FeedbackActivity.class);
        startActivity(i);
    }

    // update language

    // update language
    public void updateLanguage(){

        //1=English ; 2=Urdu; 3=Frech; 4=Espanol; 5=Hindi
        // variable intitalization
        String preference_filename = "realmurdu" ;
        String language = "languageKey";

        SharedPreferences sharedPreferences = getSharedPreferences(preference_filename, Context.MODE_PRIVATE);

        int final_lang_id =  sharedPreferences.getInt(language, 0);

        if(final_lang_id == 1){
            Locale locale = new Locale("en");

            Resources res = getBaseContext().getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = locale;

            res.updateConfiguration(conf, dm);
            getBaseContext().getResources().updateConfiguration(
                    getBaseContext().getResources().getConfiguration(),
                    getBaseContext().getResources().getDisplayMetrics()
            );
        }
        else if(final_lang_id == 2){
            Locale locale = new Locale("ur","PK");
            Resources res = getBaseContext().getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = locale;

            res.updateConfiguration(conf, dm);
            getBaseContext().getResources().updateConfiguration(
                    getBaseContext().getResources().getConfiguration(),
                    getBaseContext().getResources().getDisplayMetrics()
            );
        }
        else if(final_lang_id == 3){
            Locale locale = new Locale("fr");

            Resources res = getBaseContext().getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = locale;

            res.updateConfiguration(conf, dm);
            getBaseContext().getResources().updateConfiguration(
                    getBaseContext().getResources().getConfiguration(),
                    getBaseContext().getResources().getDisplayMetrics()
            );
        }
        else if(final_lang_id == 4){
            Locale locale = new Locale("es");

            Resources res = getBaseContext().getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = locale;

            res.updateConfiguration(conf, dm);
            getBaseContext().getResources().updateConfiguration(
                    getBaseContext().getResources().getConfiguration(),
                    getBaseContext().getResources().getDisplayMetrics()
            );
        }
        else if(final_lang_id == 5){
            Locale locale = new Locale("hi");

            Resources res = getBaseContext().getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = locale;

            res.updateConfiguration(conf, dm);
            getBaseContext().getResources().updateConfiguration(
                    getBaseContext().getResources().getConfiguration(),
                    getBaseContext().getResources().getDisplayMetrics()
            );
        }

    }
}
