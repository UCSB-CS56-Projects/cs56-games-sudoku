package edu.ucsb.cs56.w12.choice.issue460;
/**
   An exception for invalid moves in Sudoku, used in SudokuBoard
   (its an unchecked exception, so it extends  RuntimeException rather than Exception)

   @author May Camp
   @version CS56 Winter 2012, choice points, UCSB
   @see SudokuBoard
 */
public class InvalidSudokuMoveException extends RuntimeException {

    public InvalidSudokuMoveException() {};

    public InvalidSudokuMoveException(String msg) {
	super(msg);
    }
}
