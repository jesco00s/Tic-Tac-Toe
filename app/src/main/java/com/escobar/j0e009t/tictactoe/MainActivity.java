package com.escobar.j0e009t.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String Letter_X = "X";
    String Letter_O = "O";
    String EMPTY = "EMPTY";
    String currentPlayer = Letter_X;
    String[] usedSpots = {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY};
    boolean gameIsActive = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void placeImg(View view){

        ImageView gridSquare = (ImageView) view;
        int spot = Integer.parseInt(gridSquare.getTag().toString());

        if(usedSpots[spot].equals(EMPTY) && gameIsActive){
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
                gameIsActive = false;
                String winner = Letter_O;

                if(currentPlayer.equals(Letter_O))
                    winner = Letter_X;


                TextView textView = findViewById(R.id.winnerMsg);
                textView.setText("Player " + winner + " won!");

                LinearLayout linearLayout = findViewById(R.id.playAgainLayout);
                linearLayout.setVisibility(View.VISIBLE);
            }
        }
        else if(gameIsActive){
            boolean restart = true;
            for(String currentSpot : usedSpots){
                if(currentSpot.equals(EMPTY)){
                    restart = false;
                }
            }
            if(restart){
                playAgain(view);
            }
        }
    }

    public void playAgain(View view){
        gameIsActive = true;
        LinearLayout linearLayout = findViewById(R.id.playAgainLayout);
        linearLayout.setVisibility(View.INVISIBLE);

        currentPlayer = Letter_X;
        String[] empty = {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY};
        setUsedSpots(empty);
        resetGame();
    }

    public void setUsedSpots(String[] usedSpots){
        this.usedSpots = usedSpots;
    }

    public boolean checkFor3InRow(String direction){
        boolean isOver=false;

        switch(direction){
            case "horizontal" :
                isOver = checkTraditionLines(7, 1, 3);
                break;
            case "vertical" :
                isOver = checkTraditionLines(3, 3, 1);
                break;
            case "backward" :
                isOver = checkDiagonalLines(0, 8);
                break;
            case "forward" :
                isOver = checkDiagonalLines(6, 2);
                break;
        }
        return isOver;
    }

    public boolean checkTraditionLines(int innerLoopMax, int checkIncrementer, int finalIncrementer) {
        int j = 0;
        boolean threeInRow = false;
        String letter = Letter_X;

        while (j<2 && threeInRow == false){
            int i = 0;
            while (i < innerLoopMax && threeInRow == false) {
                if (usedSpots[i].equals(letter) && usedSpots[i + checkIncrementer].equals(letter) && usedSpots[i + (2 *checkIncrementer)].equals(letter)) {
                    threeInRow = true;
                }
                i = i + finalIncrementer;
            }
            letter = Letter_O;
            j++;
        }
        return threeInRow;
    }

    public boolean checkDiagonalLines(int first, int last){
        boolean threeInRow = false;
        int i = 0;
        String letter = Letter_X;

        while (i<2 && threeInRow == false) {
            if (usedSpots[first].equals(letter) && usedSpots[4].equals(letter) && usedSpots[last].equals(letter)) {
                threeInRow = true;
            }
            letter = Letter_O;
            i++;
        }
        return threeInRow;
    }

    private boolean someoneWon(){
        boolean gameOver = false;




        gameOver = checkFor3InRow("horizontal");
        if(gameOver == false){
            gameOver = checkFor3InRow("vertical");

        }
        if(gameOver == false){
            gameOver = checkFor3InRow("forward");
        }
        if(gameOver == false){
            gameOver = checkFor3InRow("backward");
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
