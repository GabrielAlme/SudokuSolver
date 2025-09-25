import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sudoku {

    public static int fileCheck(String fileName){
        File file = new File(fileName);
        try(Scanner fileRead = new Scanner(file)){
            if(fileRead.hasNextLine()){
                String boardSize = fileRead.nextLine();
                if(boardSize.equals("9x9")){ return 9; }
                if(boardSize.equals("4x4")){ return 4; }
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
        if(boardType == 4){

        }
        if(boardType == 9){

        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, please input the filename for a sudoku puzzle.");
        String fileName = scanner.nextLine();
        System.out.println(fileCheck(fileName));
        scanner.close();
    }
}