package com.example.shawaiz.realmurdu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_feedback, menu);
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


    // feedback submission via email intent
    public void sendFeedback(View v) {

        EditText tbMessage = (EditText) findViewById(R.id.feedback_comments);
        String message = tbMessage.getText().toString();

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, "shahshawaiz@gmail.com");
        emailIntent.putExtra(Intent.EXTRA_CC, "shahshawaiz@gmail.com");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback regarding REALMURDU");
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);

        try {
            startActivity(Intent.createChooser(emailIntent, "Sending email via your email client."));
            finish();

            Toast.makeText(this, "Your feedback has been sent.", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(this, HomeActivity.class);
            startActivity(i);
        }

        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

    // feedback textarea reset
    public void resetFeedback(View v) {

        EditText tbMessage = (EditText) findViewById(R.id.feedback_comments);
        tbMessage.setText("");
    }
}
