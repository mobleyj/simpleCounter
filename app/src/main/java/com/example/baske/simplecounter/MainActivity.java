package com.example.baske.simplecounter;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements OnClickListener {
    Button advance;
    Button saveCount;
    TextView theCount;
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        advance = (Button)findViewById(R.id.advance);
        saveCount = (Button)findViewById(R.id.saveCount);
        theCount = (TextView)findViewById(R.id.count);

        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        String restoredCount = preferences.getString("theCount", null);
        if (restoredCount != null)
        {
            theCount.setText(restoredCount);
        }



        advance.setOnClickListener(this);
        saveCount.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){

        if(v == advance){
            counter++;
            theCount.setText(Integer.toString(counter));
        }

        if(v == saveCount){
           SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = preferences.edit();

            editor.putString("theCount", (Integer.toString(counter)));
            TextView save = (TextView)findViewById(R.id.didSave);
            save.setText("Saved!");

        }

    }
}

