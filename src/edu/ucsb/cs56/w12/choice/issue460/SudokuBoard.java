package edu.ucsb.cs56.w12.choice.issue460;

/**
   A class to save the state of a sudoku game.

   @author May Camp
   @version for choice points assignment CS56, W12, UCSB
*/
public class SudokuBoard {
    //a board with 9 rows and 9 columns [row][column]
    private int[][] board = new int[9][9];

    /**
       A constructor to make a sudoku board with no numbers in it
    */
    public SudokuBoard() {
	board = new int[9][9];
    }

    /**
       A method to get the value in a square
       @param  row   An integer indicating the row of the square
       @param  col   An integer indicating the column of the square
       @return num   An integer representing the value in the square
    */
    public int getSquare(int row, int col) {
	return board[row][col];
    }

    /**
       A method to see if the value is allowed to be in a specific square
       @param row   An integer indicating the row of the square
       @param col   An integer indicating column of the square
       @param num   An integer indicating the value to check for validity
       @return tf   A boolean value indicating if value can go in that square
    */
    public boolean isValid(int row, int col, int num) {
	//0 is a placeholder. It means there is no number in that square.	

	//can only enter integers 0-9
	if( num < 0 || num > 9 ) {
	    return false;
	}
	// row or col are of range (0-8)
	if( row < 0 || row > 8 || col < 0 || col > 8 ) {
	    return false;
	}
	//there can be multiple 0's in each row/col/box
	if( num != 0 ) {
	    /////check if the number is in row
	    for( int i=0; i<9; i++ ) {
		if(board[row][i] == num) return false;
	    }
	    /////check if number is in col
	    for( int j=0; j<9; j++ ) {
		if(board[j][col] == num) return false;
	    }
	    /////check if number is in box
	    //
	    int curRow = indexToSquareOffset(row);
	    int curCol = indexToSquareOffset(col);







	    // /////check if number is in box
	    // int curRow; //current row
	    // if( row >= 0 && row < 3 ) {
	    // 	curRow = 0;
	    // } else { 
	    // 	if( row >= 3 && row < 6 ) {
	    // 	    curRow = 3;
	    // 	} else curRow = 6;
	    // }
	    // int curCol; // current column
	    // if( col >= 0 && col < 3 ) {
	    // 	curCol = 0;
	    // } else { 
	    // 	if( col >= 3 && col < 6 ) {
	    // 	    curCol = 3;
	    // 	} else curCol = 6;
	    // }
	    //loop through each square to see if num equals any val in them
	    for( int m=0; m<3; m++ ) {
		for( int n=0; n<3; n++ ) {
		    if( this.getSquare(n + curRow, m + curCol) == num ) {
			return false;
		    }
		}
	    }
	}
	return true; 
    }


    /**
       A setter method to put numbers into a box of the sudoku board
       @param row    An integer indicating what row to set the value in
       @param col    An integer indicating what column to set the value in
       @param val    An integer indicating what value to set in the given row and column 
    */
    public void setSquare(int row, int col, int val) throws InvalidSudokuMoveException{

	if (this.isValid(row, col, val)) {
	    board[row][col] = val;
	} else {
	    throw new InvalidSudokuMoveException();
	}

    }

    /**
       Turn sudoku board into a string to print out
       @return sudokuString A string of the entire sudoku board.

    */
    //    Turn sudoku into a string that prints:
    //    1 2 3 | 1 2 3 | 1 2 3 \n
    //    1 2 3 | 1 2 3 | 1 2 3 \n
    //    1 2 3 | 1 2 3 | 1 2 3 \n
    //    ------+-------+------\n
    //    1 2 3 | 1 2 3 | 1 2 3 \n
    //    1 2 3 | 1 2 3 | 1 2 3 \n
    //    1 2 3 | 1 2 3 | 1 2 3 \n
    //    ------+-------+------\n
    //    1 2 3 | 1 2 3 | 1 2 3 \n
    //    1 2 3 | 1 2 3 | 1 2 3 \n
    //    1 2 3 | 1 2 3 | 1 2 3 \n
    //    (prints '-' if there is no number, or if the number is '0')
    //    Blank sudoku board prints as:
    //    - - - | - - - | - - - \n
    //    - - - | - - - | - - - \n
    //    - - - | - - - | - - - \n
    //    ------+-------+------\n
    //    - - - | - - - | - - - \n
    //    - - - | - - - | - - - \n
    //    - - - | - - - | - - - \n
    //    ------+-------+------\n
    //    - - - | - - - | - - - \n
    //    - - - | - - - | - - - \n
    //    - - - | - - - | - - - \n

    public String toString() {
	String toReturn = "";
	//print top three boxes
	for(int i=0; i<3; i++) {
	    for( int j=0; j<9; j++ ) {
		if( board[i][j] == 0 ) {
		    toReturn = toReturn + "-";
		    if(j != 8 ) {
			toReturn = toReturn + " ";
		    }
		} else {
		    toReturn = toReturn + board[i][j];
		    if(j != 8 ) {
			toReturn = toReturn + " ";
		    }
		}
	    
		if( j==2 || j==5 ) {
		    toReturn = toReturn + "| ";
		}
		if( j==8 ) {
		    toReturn = toReturn + "\n";
		}
	    }
	}
	//print middle three boxes
	toReturn = toReturn + "------+-------+------\n";
	for( int i=3; i<6; i++ ) {
	    for( int j=0; j<9; j++ ) {
		if( board[i][j] == 0 ) {
		    toReturn = toReturn + "-";
		    if(j != 8) {
			toReturn = toReturn + " ";
		    }
		} else {
		    toReturn = toReturn + board[i][j];
		    if( j != 8 ) {
			toReturn = toReturn + " ";
		    }
		}
		if( j==2 || j==5 ) {
		    toReturn = toReturn + "| ";
		}
		if( j==8 ) {
		    toReturn = toReturn + "\n";
		}
	    }
	}
	//print bottom three boxes
	toReturn = toReturn + "------+-------+------\n";
	for( int i=6; i<9; i++ ) {
	    for( int j=0; j<9; j++ ) {
		if( board[i][j] == 0 ) {
		    toReturn = toReturn + "-";
		    if( j != 8 ) {
			toReturn = toReturn + " ";
		    }
		} else {
		    toReturn = toReturn + board[i][j];
		    if( j != 8 ) {
			toReturn = toReturn + " ";
		    }
		}
		if( j==2 || j==5 ) {
		    toReturn = toReturn + "| ";
		}
		if( j==8 ) {
		    toReturn = toReturn + "\n";
		}
	    }
	}
	return toReturn;
    }

    /** 
	@param i         An integer showing a row or column in the board
	@return (i/3)*3  An integer of the upper left square in the box
     */
    public static int indexToSquareOffset(int i) { return (i/3)*3;}




    /**
       To test out functions
    */

    public static void main (String[] args) {

	System.out.println("Currently, this main function was just for some side testing to see how things look.");


	SudokuBoard testBoard = new SudokuBoard();
	testBoard.setSquare( 0, 0, 0 );
	testBoard.setSquare( 0, 1, 2 );
	testBoard.setSquare( 0, 2, 3 );
	testBoard.setSquare( 1, 0, 4 );
	testBoard.setSquare( 1, 1, 5 );
	testBoard.setSquare( 1, 2, 6 );
	testBoard.setSquare( 2, 0, 7 );
	testBoard.setSquare( 2, 1, 8 );
	testBoard.setSquare( 2, 2, 9 );
	System.out.println(testBoard.toString());
	System.out.println("Can we put a 5 in (0,0)?");
	System.out.println(testBoard.isValid( 0, 0, 5));


	SudokuBoard toPrint = new SudokuBoard();
	toPrint.setSquare(0,0,1);
	toPrint.setSquare(0,1,2);
	toPrint.setSquare(0,2,3);
	toPrint.setSquare(0,3,4);
	toPrint.setSquare(0,4,5);
	toPrint.setSquare(0,5,6);
	toPrint.setSquare(0,6,7);
	toPrint.setSquare(0,7,8);
	String aStringToPrint = toPrint.toString();
	System.out.println(aStringToPrint);

	// SudokuBoard pos = new SudokuBoard();
	// pos.setSquare(0,1,1);
	// System.out.println(pos.getSquare(0,1));
    }

}