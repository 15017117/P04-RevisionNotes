package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnInsert,btnShowList;
    EditText etNote;
    RadioGroup rgStars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = (Button)findViewById(R.id.buttonInsertNote);
        btnShowList =(Button)findViewById(R.id.buttonShowList);
        rgStars = (RadioGroup)findViewById(R.id.radioGroupStars);

        etNote = (EditText)findViewById(R.id.editTextNote);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedradio = rgStars.getCheckedRadioButtonId();

                RadioButton rb = (RadioButton)findViewById(selectedradio);
                //Create the DBHelper object , passing in the
           int selectedrb = Integer.parseInt(rb.getText().toString());
                //activity's Context
                DBHelper db = new DBHelper(MainActivity.this);
                //Insert a task
                db.insertNote(etNote.getText().toString(),selectedrb);
                db.close();
            }
        });
        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(j);

                DBHelper db = new DBHelper(MainActivity.this);
                ArrayList<String> data = db.getNoteContent();
                db.close();
                String txt = "";
                for(int i =0;i<data.size();i++){
                    Log.d("Database Content" ,i+". "+data.get(i));
                    txt += i +". "+data.get(i)+"\n";
                }
                j.putExtra("txt",txt);


            }
        });


    }
}
