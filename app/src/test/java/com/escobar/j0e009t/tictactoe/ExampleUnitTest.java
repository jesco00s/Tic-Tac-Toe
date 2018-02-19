package com.escobar.j0e009t.tictactoe;

import junit.framework.Assert;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    String EMPTY = "EMPTY";
    String Letter_X = "X";
    String Letter_O = "O";

    MainActivity mainActivity = new MainActivity();

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void checkTrueHorizontals(){
        Assert.assertTrue(checkFirst3TrueHorizontals());

    }

    public boolean checkFirst3TrueHorizontals(){
        String[] usedSpots = {Letter_X, Letter_X, Letter_X, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY};
        mainActivity.setUsedSpots(usedSpots);
        return mainActivity.checkHorizontals(Letter_X);

        int i;
        for(i=0; i<8; i=i+3){
            usedSpots[i] = EMPTY;
            usedSpots[i+1] = EMPTY;
            usedSpots[i+2] = EMPTY;
        }
    }

    public boolean check3TrueHorizontals(String[] usedSpots){
        String[] usedSpots = {EMPTY, EMPTY, EMPTY, Letter_X, Letter_X, Letter_X, EMPTY, EMPTY, EMPTY};
        mainActivity.setUsedSpots(usedSpots);
        return mainActivity.checkHorizontals(Letter_X);
    }
}