package com.myapplicationdev.android.p04_revisionnotes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
	ListView lv;
	RevisionNotesArrayAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		lv = (ListView)findViewById(R.id.lv);

		DBHelper dbh = new DBHelper(this);
		ArrayList<Note> notes = dbh.getAllNotes();

		//TODO implement the Custom ListView
		adapter = new RevisionNotesArrayAdapter(this,R.layout.row,notes);
		lv.setAdapter(adapter);

	}


}
