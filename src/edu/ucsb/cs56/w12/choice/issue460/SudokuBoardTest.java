package edu.ucsb.cs56.w12.choice.issue460;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/** test class for SudokuBoard
    @author May Camp
    @version 2/25/12 CS56 Choice Points, W12, UCSB
    @see SudokuBoard
*/

public class SudokuBoardTest {


    /**
       Test case for SudokuBoard.getSquare()
       @see SudokuBoard
     */
    @Test
	public void test_getSquare() {
	SudokuBoard testBoard = new SudokuBoard();
	testBoard.setSquare(0,1,1);
	assertEquals(1, testBoard.getSquare(0,1));
    }

    /**
       Test case for SudokuBoard.toString()
       @see SudokuBoard
    */
    @Test
	public void test_toString() {
	SudokuBoard emptyBoard = new SudokuBoard();
	assertEquals("- - - | - - - | - - -\n" +
		     "- - - | - - - | - - -\n" +
		     "- - - | - - - | - - -\n" +
		     "------+-------+------\n" +
		     "- - - | - - - | - - -\n" +
		     "- - - | - - - | - - -\n" +
		     "- - - | - - - | - - -\n" +
		     "------+-------+------\n" +
		     "- - - | - - - | - - -\n" +
		     "- - - | - - - | - - -\n" +
		     "- - - | - - - | - - -\n", emptyBoard.toString());
	
	//System.out.println(emptyBoard.toString());
    }
    /**
       Test case for InvalidSudokuMoveException
       @see SudokuBoard
    */
    @Test(expected=InvalidSudokuMoveException.class)
	public void test_setSquareInvalidSudokuMove() {
	SudokuBoard testBoard = new SudokuBoard();
	testBoard.setSquare(0,0,-2);
    }

    /**
       Test case for InvalidSudokuMoveException
       @see SudokuBoard
    */
    @Test(expected=InvalidSudokuMoveException.class)
	public void test_setSquareInvalidSudokuMove2() {
	SudokuBoard testBoard = new SudokuBoard();
	testBoard.setSquare(-2,0,1);
    }

    /**
       Test case for InvalidSudokuMoveException
       @see SudokuBoard
    */
    @Test(expected=InvalidSudokuMoveException.class)
	public void test_setSquareInvalidSudokuMove3() {
	SudokuBoard testBoard = new SudokuBoard();
	testBoard.setSquare(12,0,1);
    }

    /**
       Test case for InvalidSudokuMoveException
       @see SudokuBoard
    */
    @Test(expected=InvalidSudokuMoveException.class)
	public void test_setSquareInvalidSudokuMove4() {
	SudokuBoard testBoard = new SudokuBoard();
	testBoard.setSquare(0,-2,1);
    }

    /**
       Test case for InvalidSudokuMoveException
       @see SudokuBoard
    */
    @Test(expected=InvalidSudokuMoveException.class)
	public void test_setSquareInvalidSudokuMove5() {
	SudokuBoard testBoard = new SudokuBoard();
	testBoard.setSquare(0,12,1);
    }


    /**
       Test case for SudokuBoard.setSquare()
       @see SudokuBoard
     */
    @Test
	public void test_setSquare() {
	SudokuBoard testBoard = new SudokuBoard();
	try{
	    testBoard.setSquare(0,0,1);
	} catch(InvalidSudokuMoveException ex){
	    ex.printStackTrace();
	    }
	assertEquals("1 - - | - - - | - - -\n" +
		     "- - - | - - - | - - -\n" +
		     "- - - | - - - | - - -\n" +
		     "------+-------+------\n" +
		     "- - - | - - - | - - -\n" +
		     "- - - | - - - | - - -\n" +
		     "- - - | - - - | - - -\n" +
		     "------+-------+------\n" +
		     "- - - | - - - | - - -\n" +
		     "- - - | - - - | - - -\n" +
		     "- - - | - - - | - - -\n",testBoard.toString());
    }
    /** 
	Test case for SudokuBoard.setSquare()
	testing difference between row and col
	@see SudokuBoard
    */
    @Test
	public void test_setSquare2() {
	SudokuBoard testBoard = new SudokuBoard();
	try {
	    testBoard.setSquare(0,1,1);
	} catch(InvalidSudokuMoveException ex){
	    ex.printStackTrace();
	    }
	assertEquals("- 1 - | - - - | - - -\n" +
		     "- - - | - - - | - - -\n" +
		     "- - - | - - - | - - -\n" +
		     "------+-------+------\n" +
		     "- - - | - - - | - - -\n" +
		     "- - - | - - - | - - -\n" +
		     "- - - | - - - | - - -\n" +
		     "------+-------+------\n" +
		     "- - - | - - - | - - -\n" +
		     "- - - | - - - | - - -\n" +
		     "- - - | - - - | - - -\n",testBoard.toString());
    }

    /** 
	Test case for SudokuBoard.setSquare()
	testing whole board set up
	@see SudokuBoard
    */
    @Test
	public void test_setSquare3() {
	SudokuBoard testBoard = new SudokuBoard();
	try {
	    testBoard.setSquare(0,0,1);
	    testBoard.setSquare(0,1,2);
	    testBoard.setSquare(0,2,3);
	    testBoard.setSquare(0,3,4);
	    testBoard.setSquare(0,4,5);
	    testBoard.setSquare(0,5,6);
	    testBoard.setSquare(0,6,7);
	    testBoard.setSquare(0,7,8);
	    testBoard.setSquare(0,8,9);

	    testBoard.setSquare(1,0,4);
	    testBoard.setSquare(1,1,5);
	    testBoard.setSquare(1,2,6);
	    testBoard.setSquare(1,3,7);
	    testBoard.setSquare(1,4,8);
	    testBoard.setSquare(1,5,9);
	    testBoard.setSquare(1,6,1);
	    testBoard.setSquare(1,7,2);
	    testBoard.setSquare(1,8,3);

	    testBoard.setSquare(2,0,7);
	    testBoard.setSquare(2,1,8);
	    testBoard.setSquare(2,2,9);
	    testBoard.setSquare(2,3,1);
	    testBoard.setSquare(2,4,2);
	    testBoard.setSquare(2,5,3);
	    testBoard.setSquare(2,6,4);
	    testBoard.setSquare(2,7,5);
	    testBoard.setSquare(2,8,6);

	    testBoard.setSquare(3,0,2);
	    testBoard.setSquare(3,1,3);
	    testBoard.setSquare(3,2,1);
	    testBoard.setSquare(3,3,5);
	    testBoard.setSquare(3,4,6);
	    testBoard.setSquare(3,5,4);
	    testBoard.setSquare(3,6,8);
	    testBoard.setSquare(3,7,9);
	    testBoard.setSquare(3,8,7);

	    testBoard.setSquare(4,0,5);
	    testBoard.setSquare(4,1,6);
	    testBoard.setSquare(4,2,4);
	    testBoard.setSquare(4,3,8);
	    testBoard.setSquare(4,4,9);
	    testBoard.setSquare(4,5,7);
	    testBoard.setSquare(4,6,2);
	    testBoard.setSquare(4,7,3);
	    testBoard.setSquare(4,8,1);

	    testBoard.setSquare(5,0,8);
	    testBoard.setSquare(5,1,9);
	    testBoard.setSquare(5,2,7);
	    testBoard.setSquare(5,3,2);
	    testBoard.setSquare(5,4,3);
	    testBoard.setSquare(5,5,1);
	    testBoard.setSquare(5,6,5);
	    testBoard.setSquare(5,7,6);
	    testBoard.setSquare(5,8,4);

	    testBoard.setSquare(6,0,3);
	    testBoard.setSquare(6,1,1);
	    testBoard.setSquare(6,2,2);
	    testBoard.setSquare(6,3,6);
	    testBoard.setSquare(6,4,4);
	    testBoard.setSquare(6,5,5);
	    testBoard.setSquare(6,6,9);
	    testBoard.setSquare(6,7,7);
	    testBoard.setSquare(6,8,8);

	    testBoard.setSquare(7,0,6);
	    testBoard.setSquare(7,1,4);
	    testBoard.setSquare(7,2,5);
	    testBoard.setSquare(7,3,9);
	    testBoard.setSquare(7,4,7);
	    testBoard.setSquare(7,5,8);
	    testBoard.setSquare(7,6,3);
	    testBoard.setSquare(7,7,1);
	    testBoard.setSquare(7,8,2);

	    testBoard.setSquare(8,0,9);
	    testBoard.setSquare(8,1,7);
	    testBoard.setSquare(8,2,8);
	    testBoard.setSquare(8,3,3);
	    testBoard.setSquare(8,4,1);
	    testBoard.setSquare(8,5,2);
	    testBoard.setSquare(8,6,6);
	    testBoard.setSquare(8,7,4);
	    testBoard.setSquare(8,8,5);

	} catch(InvalidSudokuMoveException ex){
	    ex.printStackTrace();
	    }
	assertEquals("1 2 3 | 4 5 6 | 7 8 9\n" +
		     "4 5 6 | 7 8 9 | 1 2 3\n" +
		     "7 8 9 | 1 2 3 | 4 5 6\n" +
		     "------+-------+------\n" +
		     "2 3 1 | 5 6 4 | 8 9 7\n" +
		     "5 6 4 | 8 9 7 | 2 3 1\n" +
		     "8 9 7 | 2 3 1 | 5 6 4\n" +
		     "------+-------+------\n" +
		     "3 1 2 | 6 4 5 | 9 7 8\n" +
		     "6 4 5 | 9 7 8 | 3 1 2\n" +
		     "9 7 8 | 3 1 2 | 6 4 5\n",testBoard.toString());
    }


    /**
       Test case for SudokuBoard.isValid()
       Testing if something CAN fit
       @see SudokuBoard
     */
    @Test
	public void test_isValid() {
	SudokuBoard testBoard = new SudokuBoard();
	try{
	    testBoard.setSquare( 0, 0, 0 );
	    testBoard.setSquare( 0, 1, 2 );
	    testBoard.setSquare( 0, 2, 3 );
	    testBoard.setSquare( 0, 3, 4 );
	    testBoard.setSquare( 0, 4, 5 );
	    testBoard.setSquare( 0, 5, 6 );
	    testBoard.setSquare( 0, 6, 7 );
	    testBoard.setSquare( 0, 7, 8 );
	    testBoard.setSquare( 0, 8, 9 );
	} catch(InvalidSudokuMoveException ex){
	    ex.printStackTrace();
	    }

	boolean trueOrNot = testBoard.isValid( 0, 0, 1);
	assertEquals(true, trueOrNot);
    }

    /**
       Test case for SudokuBoard.isValid()
       Testing if value cannot fit in row
       @see SudokuBoard
     */
    @Test
	public void test_isValid2() {
	SudokuBoard testBoard = new SudokuBoard();
	try{
	    testBoard.setSquare( 0, 0, 0 );
	    testBoard.setSquare( 0, 1, 2 );
	    testBoard.setSquare( 0, 2, 3 );
	    testBoard.setSquare( 0, 3, 4 );
	    testBoard.setSquare( 0, 4, 5 );
	    testBoard.setSquare( 0, 5, 6 );
	    testBoard.setSquare( 0, 6, 7 );
	    testBoard.setSquare( 0, 7, 8 );
	    testBoard.setSquare( 0, 8, 9 );

	} catch(InvalidSudokuMoveException ex){
	    ex.printStackTrace();
	    }
	boolean trueOrNot = testBoard.isValid( 0, 0, 5);
	
	assertEquals(false, trueOrNot);
    }
    /**
       Test case for SudokuBoard.isValid()
       Testing if value cannot fit in col
       @see SudokuBoard
     */
    @Test
	public void test_isValid3() {
	SudokuBoard testBoard = new SudokuBoard();
	try{
	    testBoard.setSquare( 0, 0, 0 );
	    testBoard.setSquare( 1, 0, 2 );
	    testBoard.setSquare( 2, 0, 3 );
	    testBoard.setSquare( 3, 0, 4 );
	    testBoard.setSquare( 4, 0, 5 );
	    testBoard.setSquare( 5, 0, 6 );
	    testBoard.setSquare( 6, 0, 7 );
	    testBoard.setSquare( 7, 0, 8 );
	    testBoard.setSquare( 8, 0, 9 );
	} catch(InvalidSudokuMoveException ex){
	    ex.printStackTrace();
	    }

	boolean trueOrNot = testBoard.isValid( 0, 0, 5);
	assertEquals(false, trueOrNot);
    }
    /**
       Test case for SudokuBoard.isValid()
       Testing if value cannot fit in upper left box
       @see SudokuBoard
     */
    @Test
	public void test_isValid4() {
	SudokuBoard testBoard = new SudokuBoard();
	try{
	    testBoard.setSquare( 0, 0, 0 );
	    testBoard.setSquare( 0, 1, 2 );
	    testBoard.setSquare( 0, 2, 3 );
	    testBoard.setSquare( 1, 0, 4 );
	    testBoard.setSquare( 1, 1, 5 );
	    testBoard.setSquare( 1, 2, 6 );
	    testBoard.setSquare( 2, 0, 7 );
	    testBoard.setSquare( 2, 1, 8 );
	    testBoard.setSquare( 2, 2, 9 );
	} catch(InvalidSudokuMoveException ex){
	    ex.printStackTrace();
	    }


	boolean trueOrNot = testBoard.isValid( 0, 0, 5);
	assertEquals(false, trueOrNot);
    }

    /**
       Test case for SudokuBoard.isValid()
       Testing if value cannot fit in upper middle box
       @see SudokuBoard
     */
    @Test
	public void test_isValid5() {
	SudokuBoard testBoard = new SudokuBoard();
	try{
	    testBoard.setSquare( 0, 3, 0 );
	    testBoard.setSquare( 1, 3, 2 );
	    testBoard.setSquare( 2, 3, 3 );
	    testBoard.setSquare( 0, 4, 4 );
	    testBoard.setSquare( 1, 4, 5 );
	    testBoard.setSquare( 2, 4, 6 );
	    testBoard.setSquare( 0, 5, 7 );
	    testBoard.setSquare( 1, 5, 8 );
	    testBoard.setSquare( 2, 5, 9 );
	} catch(InvalidSudokuMoveException ex){
	    ex.printStackTrace();
	    }


	boolean trueOrNot = testBoard.isValid( 0, 3, 5);
	assertEquals(false, trueOrNot);
    }

    /**
       Test case for SudokuBoard.isValid()
       Testing if numbers greater than 9 returns false
       @see SudokuBoard
     */
    @Test
	public void test_isValid6() {
	SudokuBoard testBoard = new SudokuBoard();

	boolean trueOrNot = testBoard.isValid( 0, 0, 10);
	assertEquals(false, trueOrNot);
    }
    /**
       Test case for SudokuBoard.isValid()
       Testing if numbers less than 0 returns false
       @see SudokuBoard
     */
    @Test
	public void test_isValid7() {
	SudokuBoard testBoard = new SudokuBoard();

	boolean trueOrNot = testBoard.isValid( 0, 0, -2);
	assertEquals(false, trueOrNot);
    }

    /**
       Test case for SudokuBoard.isValid()
       Testing if row < 0 returns false
       @see SudokuBoard
     */
    @Test
	public void test_isValid8() {
	SudokuBoard testBoard = new SudokuBoard();

	boolean trueOrNot = testBoard.isValid( -2, 0, 1);
	assertEquals(false, trueOrNot);
    }

    /**
       Test case for SudokuBoard.isValid()
       Testing if row > 9 returns false
       @see SudokuBoard
     */
    @Test
	public void test_isValid9() {
	SudokuBoard testBoard = new SudokuBoard();

	boolean trueOrNot = testBoard.isValid( 12, 0, 1);
	assertEquals(false, trueOrNot);
    }

    /**
       Test case for SudokuBoard.isValid()
       Testing if col < 0 returns false
       @see SudokuBoard
     */
    @Test
	public void test_isValid10() {
	SudokuBoard testBoard = new SudokuBoard();

	boolean trueOrNot = testBoard.isValid( 0, -2, 1);
	assertEquals(false, trueOrNot);
    }

    /**
       Test case for SudokuBoard.isValid()
       Testing if col > 9 returns false
       @see SudokuBoard
     */
    @Test
	public void test_isValid11() {
	SudokuBoard testBoard = new SudokuBoard();

	boolean trueOrNot = testBoard.isValid( 0, 12, 1);
	assertEquals(false, trueOrNot);
    }

    
}