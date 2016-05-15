package com.example.shawaiz.realmurdu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        // initiate variables
        String alphabet = "alphabet_1";
        String object = "object_1";

        // get hanlders of question and answer image views
        ImageView question = (ImageView) findViewById(R.id.question);
        ImageView option1 = (ImageView) findViewById(R.id.option1);
        ImageView option2 = (ImageView) findViewById(R.id.option2);
        ImageView option3 = (ImageView) findViewById(R.id.option3);
        ImageView optionone = (ImageView) findViewById(R.id.optionnone);

        // retrieve list
        List objects = this.getObject();
        List alphabets = this.getAlphabets();



        // get random item from list
        String question_value = this.getRandomList(objects);
        String option1_value = this.getRandomList(alphabets);
        String option2_value = this.getRandomList(alphabets);
        String option3_value = this.getRandomList(alphabets);

        String item = question_value.substring(question_value.lastIndexOf("_")+1);

        //set image resource value
        question.setImageResource(getResources().getIdentifier(question_value, "drawable", getPackageName()));
        option1.setImageResource(getResources().getIdentifier(option1_value, "drawable", getPackageName()));
        option2.setImageResource(getResources().getIdentifier(option2_value, "drawable", getPackageName()));
        option3.setImageResource(getResources().getIdentifier(option3_value, "drawable", getPackageName()));

        // equate tag with resource name
        question.setTag(question_value);
        option1.setTag(option1_value);
        option2.setTag(option2_value);
        option3.setTag(option3_value);
        optionone.setTag("0");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game1, menu);
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




    // check answer
    public void checkAnswer(View view){

        //get question value
        ImageView question = (ImageView) findViewById(R.id.question);
        String question_value = question.getTag().toString();

        question_value = question_value.substring(question_value.lastIndexOf("_") + 1);

        // get selected value
        String selected_option = view.getTag().toString();
        selected_option = selected_option.substring(selected_option.lastIndexOf("_") + 1);

        // get handler of answer
        TextView status = (TextView) findViewById(R.id.question_status_game2);


        if (Integer.parseInt(question_value) == Integer.parseInt(selected_option)) {

            status.setText(R.string.game_answer_correct);

            this.updateStats(1);
        } else {

            if(view.getTag().toString() == "0"){
                Toast.makeText(this, R.string.question_skipped, Toast.LENGTH_SHORT).show();
            }else{

                status.setText(R.string.game_answer_wrong);

                this.updateStats(0);
            }
        }

        try{ Thread.sleep(1000); }catch(InterruptedException e){ }
        this.recreate();
    }

    // update stats for shared preference
    public void updateStats(int correctness){

        // variable intitalization
        String preference_filename = "realmurdu" ;

        String game2_correct = "game2CorrectKey";
        String game2_trial = "game2TrialKey";

        // get exsisting stats
        SharedPreferences sharedPreferences = getSharedPreferences(preference_filename, Context.MODE_PRIVATE);

        int score = sharedPreferences.getInt(game2_correct, 0);
        int trial = sharedPreferences.getInt(game2_trial, 0);

        // update score and number of trials
        if(correctness==1){
            score = score+1;
        }

        trial = trial+1; //increment trial number

        // update stats
        SharedPreferences.Editor editor = getSharedPreferences(preference_filename, Context.MODE_PRIVATE).edit();

        editor.putInt(game2_correct, score);
        editor.putInt(game2_trial, trial);

        editor.commit();
    }



    // populate list
    public List getObject(){

        List<String> objects = new ArrayList<>();

        objects.add("object_1");
        objects.add("object_2");
        objects.add("object_3");
        objects.add("object_4");
        objects.add("object_5");
        objects.add("object_7");
        objects.add("object_8");
        objects.add("object_10");
        objects.add("object_12");
        objects.add("object_14");
        objects.add("object_18");
        objects.add("object_22");
        objects.add("object_25");
        objects.add("object_27");
        objects.add("object_31");

        return objects;
    }

    public List getAlphabets(){

        List<String> alphabets = new ArrayList<>();
        alphabets.add("alphabet_1");
        alphabets.add("alphabet_2");
        alphabets.add("alphabet_3");
        alphabets.add("alphabet_4");
        alphabets.add("alphabet_5");
        alphabets.add("alphabet_7");
        alphabets.add("alphabet_8");
        alphabets.add("alphabet_10");
        alphabets.add("alphabet_12");
        alphabets.add("alphabet_14");
        alphabets.add("alphabet_18");
        alphabets.add("alphabet_22");
        alphabets.add("alphabet_25");
        alphabets.add("alphabet_27");
        alphabets.add("alphabet_31");

        return alphabets;
    }

    // get lsit and return a random list element
    public String getRandomList(List<String> list) {

        //Math.random() = greater than or equal to 0.0 and less than 1
        //0-4
        int index = (int)(Math.random()*list.size());
        System.out.println("\nIndex :" + index );

        return list.get(index);
    }

}
