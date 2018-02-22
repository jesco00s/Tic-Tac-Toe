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
        String[] firstRow = createUsedSpots(new int[] {0, 1, 2});
        String[] secondRow = createUsedSpots(new int[] {3, 4, 5});
        String[] thirdRow = createUsedSpots(new int[] {6, 7, 8});

        Assert.assertTrue("First horizontal row failed", check3InRow(firstRow, "horizontal"));
        Assert.assertTrue("Second horizontal row failed", check3InRow(secondRow, "horizontal"));
        Assert.assertTrue("Third horizontal row failed", check3InRow(thirdRow, "horizontal"));
    }

    @Test
    public void checkFalseHorizontals(){
        String[] oCompletedLine = {Letter_X, Letter_X, Letter_O, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY};
        String[] empty = {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY};
        String[] wrongLetter = {Letter_O, Letter_O, Letter_O, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY};

        Assert.assertFalse("oCompletedLine was supposed to fail", check3InRow(oCompletedLine, "horizontal"));
        Assert.assertFalse("empty was supposed to fail", check3InRow(empty, "horizontal"));
        Assert.assertFalse("wrongLetter was supposed to fail", check3InRow(wrongLetter, "horizontal"));
    }

    @Test
    public void checkTrueVerticals(){


        String[] firstRow = createUsedSpots(new int[] {0, 3, 6});
        String[] secondRow = createUsedSpots(new int[] {1, 4, 7});
        String[] thirdRow = createUsedSpots(new int[] {2, 5, 8});

        Assert.assertTrue("First vertical row failed", check3InRow(firstRow, "vertical"));
        Assert.assertTrue("Second vertical row failed", check3InRow(secondRow, "vertical"));
        Assert.assertTrue("Third vertical row failed", check3InRow(thirdRow, "vertical"));
    }

    @Test
    public void checkFalseVerticals(){
        String[] oCompletedLine = {Letter_X, EMPTY, EMPTY, Letter_X, EMPTY, EMPTY, Letter_O, EMPTY, EMPTY};
        String[] empty = {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY};
        String[] wrongLetter = {Letter_O, EMPTY, EMPTY, Letter_O, EMPTY, EMPTY, Letter_O, EMPTY, EMPTY};

        Assert.assertFalse("oCompletedLine was supposed to fail", check3InRow(oCompletedLine, "vertical"));
        Assert.assertFalse("empty was supposed to fail", check3InRow(empty, "vertical"));
        Assert.assertFalse("wrongLetter was supposed to fail", check3InRow(wrongLetter, "vertical"));
    }

    @Test
    public void checkTrueForwardDiagonal(){
        String[] forwardDiagonal = {Letter_O, Letter_O, Letter_X, Letter_O, Letter_X, EMPTY, Letter_X, EMPTY, EMPTY};

        Assert.assertTrue(check3InRow(forwardDiagonal, "forward"));
    }

    @Test
    public void checkTrueBackwardDiagonal(){
        String[] forwardDiagonal = {Letter_X, EMPTY, EMPTY, EMPTY, Letter_X, EMPTY, EMPTY, EMPTY, Letter_X};

        Assert.assertTrue(check3InRow(forwardDiagonal, "backward"));
    }

    public String[] createUsedSpots(int[] index){
        String[] usedSpots = {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY};
        for(int i: index){
            usedSpots[i] = Letter_O;
        }
        return usedSpots;
    }

    public boolean check3InRow(String[] usedSpots, String direction){
        mainActivity.setUsedSpots(usedSpots);
        return mainActivity.checkFor3InRow(direction);
    }

}