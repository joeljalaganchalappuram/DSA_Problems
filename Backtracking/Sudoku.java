public class Sudoku{
    //function to check if the number you enter is safe
    public static boolean isSafe(int sudoku[][],int row,int col,int digit){
        //first I will check the coloums whether there is a same value
        for(int i=0;i<9;i++ ){
            if(sudoku[i][col]==digit){
                return false;
            }
        }
        //second I will check the rows whereter there is a same value
        for(int i=0;i<9;i++ ){
            if(sudoku[row][i]==digit){
                return false;
            }
        }
        //the third I will check the 3x3 grid
        //for this first we need to identify the where is the 3x3 grid of this cell is present
        int starting_row = (row/3)*3;
        int starting_col = (col/3)*3;
        for(int i=starting_row;i<starting_row+3;i++){
            for(int j=starting_col;j<starting_col+3;j++){
                if(sudoku[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
    }
    //this function will say wether theere is solution or not
    public static boolean sudokuSolver(int sudoku[][],int row,int col){
        //base case
        if(row == 9){
            //we can remove the col as when the row == 9 you have finished the sudoku or when the col == 9 then row is incremented and
            //so the base case row == 9 and col == 0 never comes
            return true;
        } else if (row == 9) {
            return false;
        }
        //recursion
        int nextCol = col+1;
        //row will increase when sudoku colum ends
        int nextRow = row;
        if(col+1 == 9){
            nextRow = row+1;
            nextCol = 0;
        }
        if(sudoku[row][col] != 0){
            //if not 0 then continue to the next coloum or the row according
            return sudokuSolver(sudoku,nextRow,nextCol);
        }
        for(int digit=1;digit<=9;digit++){
            if(isSafe(sudoku,row,col,digit)){
                sudoku[row][col]=digit;
                if(sudokuSolver(sudoku,nextRow,nextCol)){
                    //solution exists
                    return true;
                }
                //if solution is not able to do remove the element ad replace it with 0
                sudoku[row][col]=0;
            }
        }
        return false;
    }
    //function for printing the sudokku
    public static void printSudoku(int sudoku[][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        //sudoku 2D array and added the value in the question
        int sudoku[][] = {
                {0,0,8,0,0,0,0,0,0},
                {4,9,0,1,5,7,0,0,2},
                {0,0,3,0,0,4,1,9,0},
                {1,8,5,0,6,0,0,2,0},
                {0,0,0,0,2,0,0,6,0},
                {9,6,0,4,0,5,3,0,0},
                {0,3,0,0,7,2,0,0,4},
                {0,4,9,0,3,0,0,5,7},
                {8,2,7,0,0,9,0,1,3}
        };
        if(sudokuSolver(sudoku,0,0)){
            System.out.println("Sudoku is solved");
            printSudoku(sudoku);
        }
        else{
            System.out.println("No solution");
        }
    }
}
