import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sudoku {

    public static int fileCheck(String fileName){
        File file = new File(fileName);
        try(Scanner fileRead = new Scanner(file)){
            if(fileRead.hasNextLine()){
                String boardSize = fileRead.nextLine();
                if(boardSize.equals("9x9")){
                    fileRead.close();
                    return 9;
                }
                if(boardSize.equals("4x4")){
                    fileRead.close();
                    return 4;
                }
            fileRead.close();
            }
        } catch(FileNotFoundException e){
            System.out.println("File not found, please input a new file name.");
            return 0;
        }

        System.out.println("This is not a sudoku file, please input a new file name.");
        return 0;
    }

    public static int[][] createBoard(String fileName, int boardType){
        File file = new File(fileName);
        try (Scanner getData = new Scanner(file)){
        int[][] gameBoard = new int[boardType][boardType];
        getData.nextLine();
        System.out.println("here");
        getData.useDelimiter("[\\s,]+");
        while(getData.hasNextLine()){
            int row = getData.nextInt();
            System.out.println("ROW: " + row);
            int column = getData.nextInt();
            System.out.println("COLUMN: " + column);
            int value = getData.nextInt();
            System.out.println("VALUE: " + value);
            gameBoard[row - 1][column - 1] = value;
            if(getData.hasNextLine()){
            getData.nextLine();
            }
        }
        getData.close();
        return gameBoard;
        } catch(FileNotFoundException e){
            System.out.println("Fatal File Error");
        }
        return new int[0][0];
    }

    public static  int subRow(int current){
        if( current < 3){
            return 0;
        } else if(current < 6){
            return 3;
        }else{return 6;}
    }

    public static  int subColumn(int current){
        if( current < 3){
            return 0;
        } else if(current < 6){
            return 3;
        }else{return 6;}
    }
    public static boolean isValidInSubgrid(int[][] sudokuBoard, int rowOffset, int colOffset, int value) {//create a method to check if the value is valid in the select subgrid
        for (int i = rowOffset; i < rowOffset + 3; i++) {
            for (int j = colOffset; j < colOffset + 3; j++) {
                if (sudokuBoard[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean checkXY(int[][] sudokuBoard, int row, int column, int value, int fileType) { //write a method here to check if a value is valid within the x and y for the sudoku puzzle
        // Check the row
        for (int i = 0; i < fileType; i++) {
            if (sudokuBoard[row][i] == value) {
                return false;
            }
        }

        // Check the column
        for (int i = 0; i < fileType; i++) {
            if (sudokuBoard[i][column] == value) {
                return false;
            }
        }

        return true;
        }

    public static boolean solveSudoku(int[][] sudokuBoard, int fileType) { //rewrite solveSudoku to utilize the new methods and backtrack to solve the puzzle
        for (int row = 0; row < fileType; row++) {
            for (int column = 0; column < fileType; column++) {
                if (sudokuBoard[row][column] == 0) {
                    for (int value = 1; value <= fileType; value++) {
                        int subRowOffset = subRow(row);
                        int subColOffset = subColumn(column);
                        if (checkXY(sudokuBoard, row, column, value, fileType) &&
                            (fileType == 4 || isValidInSubgrid(sudokuBoard, subRowOffset, subColOffset, value))) { //rewrite these two lines to skip isValidInSubgrid when the fileType is 4
                            sudokuBoard[row][column] = value;
                            if (solveSudoku(sudokuBoard, fileType)) {
                                return true;
                            }
                            sudokuBoard[row][column] = 0; // Backtrack
                        }
                    }
                    return false; // No valid number found
                }
            }
        }
        return true; // Solved
    }

    public static void main(String[] args) { //rewrite the main to use the newly created functions and print the output for verification
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, please input the filename for a sudoku puzzle.");
        String fileName = scanner.nextLine();
        int fileType = fileCheck(fileName);

        if (fileType == 0) {
            System.out.println("Invalid file. Exiting program.");
            scanner.close();
            return;
        }

        int[][] sudokuBoard = createBoard(fileName, fileType);

        System.out.println("Initial Sudoku Board:");
        printBoard(sudokuBoard, fileType);

        if (solveSudoku(sudokuBoard, fileType)) {
            System.out.println("Solved Sudoku Board:");
            printBoard(sudokuBoard, fileType);
        } else {
            System.out.println("No solution exists for the given Sudoku puzzle.");
        }

        scanner.close();
    }

    public static void printBoard(int[][] board, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}