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

    public int[][] createBoard(String fileName, int boardType){
        Scanner getData = new Scanner(fileName);
        int[][] gameBoard = new int[boardType][boardType];
        Scanner file
        return gameBoard;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, please input the filename for a sudoku puzzle.");
        String fileName = scanner.nextLine();
        System.out.println(fileCheck(fileName));
        scanner.close();
    }
}