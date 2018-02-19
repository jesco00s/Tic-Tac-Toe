package com.escobar.j0e009t.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String Letter_X = "X";
    String Letter_O = "O";
    String EMPTY = "EMPTY";
    String currentPlayer = Letter_X;
    String[] usedSpots = {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY};

//    0, 1, 2
//    3, 4, 5
//    6, 7, 8

    public void setUsedSpots(String[] usedSpots){
        this.usedSpots = usedSpots;
    }

    private boolean checkHorizontals(){
        boolean isOver;
        isOver = checkHorizontals(Letter_X);
        if(isOver == false){
            isOver = checkHorizontals(Letter_O);
        }
        return isOver;
    }

    public boolean checkHorizontals(String letter){
        int i;
        boolean threeInRow = false;

        for (i=0; i<7; i = i + 3){
            if(usedSpots[i].equals(letter) && usedSpots[i+1].equals(letter) && usedSpots[i+2].equals(letter)){
                threeInRow = true;
            }
        }

        return threeInRow;
    }

    private boolean checkVerticals(){
        boolean isOver;
        isOver = checkVerticals(Letter_X);
        if(isOver == false){
            isOver = checkVerticals(Letter_O);
        }
        return isOver;
    }

    private boolean checkVerticals(String letter){
        int i;
        boolean threeInRow = false;

        for (i=0; i<3; i = i + 1){
            if(usedSpots[i].equals(letter) && usedSpots[i+3].equals(letter) && usedSpots[i+3].equals(letter)){
                threeInRow = true;
            }
        }

        return threeInRow;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void placeImg(View view){

        ImageView gridSquare = (ImageView) view;
        int spot = Integer.parseInt(gridSquare.getTag().toString());

        if(usedSpots[spot].equals(EMPTY)){
            usedSpots[spot] = currentPlayer;
            if(currentPlayer.equals(Letter_O)){
                gridSquare.setImageResource(R.drawable.letter_o);
                currentPlayer = Letter_X;
            }
            else if(currentPlayer.equals(Letter_X)){
                gridSquare.setImageResource(R.drawable.letter_x);
                currentPlayer = Letter_O;
            }

            if(someoneWon()){
                Toast.makeText(this, "Game Over", Toast.LENGTH_SHORT).show();
                resetGame();
            }

        }




    }

    private boolean someoneWon(){
        boolean gameOver = false;

        gameOver = checkHorizontals();
        if(gameOver != true){
            gameOver = checkVerticals();
        }

        return  gameOver;
    }

    private void resetGame(){
        ImageView imageView = findViewById(R.id.position0);
        imageView.setImageResource(0);

        imageView = findViewById(R.id.position1);
        imageView.setImageResource(0);

        imageView = findViewById(R.id.position2);
        imageView.setImageResource(0);

        imageView = findViewById(R.id.position3);
        imageView.setImageResource(0);

        imageView = findViewById(R.id.position4);
        imageView.setImageResource(0);

        imageView = findViewById(R.id.position5);
        imageView.setImageResource(0);

        imageView = findViewById(R.id.position6);
        imageView.setImageResource(0);

        imageView = findViewById(R.id.position7);
        imageView.setImageResource(0);

        imageView = findViewById(R.id.position8);
        imageView.setImageResource(0);

    }

}
