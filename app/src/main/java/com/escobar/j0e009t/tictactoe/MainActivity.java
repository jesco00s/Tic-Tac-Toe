package com.escobar.j0e009t.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void placeImg(View view){

        ImageView gridSpot = (ImageView) view;
        gridSpot.setImageResource(R.drawable.letter_o);
    }

}
