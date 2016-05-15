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

public class UpdateLangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_lang);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_update_lang, menu);
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


    // update language
    public void updateLanguage(View view){

        //1=English ; 2=Urdu; 3=Frech; 4=Espanol; 5=Hindi
        String lang_id = view.getTag().toString();

        int final_lang_id = Integer.parseInt(lang_id);

        // variable intitalization
        String preference_filename = "realmurdu" ;
        String language = "languageKey";

        // update stats
        SharedPreferences.Editor editor = getSharedPreferences(preference_filename, Context.MODE_PRIVATE).edit();


        if(final_lang_id == 1){
            editor.putInt(language, 1);

            // update language
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
            editor.putInt(language, 2);

            // update language
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
            editor.putInt(language, 3);

            // update language
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
            editor.putInt(language, 4);

            // update language
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
            editor.putInt(language, 5);

            // update language
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

        editor.commit();

        // restart activity
        Intent i = getBaseContext().getPackageManager()
                .getLaunchIntentForPackage(getBaseContext().getPackageName());
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        startActivity(i);
    }

}
