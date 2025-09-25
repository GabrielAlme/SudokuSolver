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

    public static boolean checkXY(int[][] sudokuBoard, int row, int column, int value,int fileType){
        for (int i = 0; i < fileType; i++){
            
        }
        return true;
    }

    public static boolean solveSudoku(int[][] sudokuBoard, int fileType) {
        if(fileType == 4){
            for(int row = 0; row < 9; row++){
                for(int column = 0; column < 9; column++){
                    if(sudokuBoard[row][column] == 0){
                        for(int count = 1; count <= 9; count++){
                            
                        }
                    }
                }
            }
        }

        if(fileType == 9){
            for(int row = 0; row < 9; row++){
                for(int column = 0; column < 9; column++){
                
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, please input the filename for a sudoku puzzle.");
        String fileName = scanner.nextLine();
        int fileType = fileCheck(fileName);
        System.out.println(fileType);
        int[][] sudokuBoard = createBoard(fileName, fileType);
        for(int i = 0; i < fileType; i++){
            for(int j = 0; j < fileType; j++){
                System.out.println(sudokuBoard[i][j]);
            }
        }
        scanner.close();
    }
}