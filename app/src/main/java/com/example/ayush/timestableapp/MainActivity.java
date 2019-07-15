package com.example.ayush.timestableapp;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> arrayAdapter;
    ListView mainListView;
    SeekBar seekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final int a = 0;
        final ArrayList<ArrayList<String>> arrayNums = new ArrayList<ArrayList<String>>();
        for(int i = 0; i < 20; i++)
        {
            arrayNums.add(new ArrayList<String>());
        }
        for(int i = 0; i < 20; i++)
        {
            for(int j = 1; j <= 10; j++)
            {
                arrayNums.get(i).add(Integer.toString(i+1) + " x " + Integer.toString(j) + " = " + Integer.toString((i+1)*j));
            }
        }

        mainListView = (ListView) findViewById(R.id.tablesListView);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayNums.get(0));
        mainListView.setAdapter(arrayAdapter);

        seekBar = findViewById(R.id.seekBar3);
        seekBar.setMax(19);
        seekBar.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        seekBar.getThumb().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arrayNums.get(i));
                mainListView.setAdapter(arrayAdapter);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
