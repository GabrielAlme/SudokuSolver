import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sudoku {

    public int fileCheck(String fileName){
        File file = new File(fileName);
        try(Scanner fileRead = new Scanner(file)){
            if(fileRead.hasNextLine()){
                String boardSize = fileRead.nextLine();
                if(boardSize.equals("9x9")){ return 9; }
                if(boardSize.equals("4x4")){ return 4; }
            }
        } catch(FileNotFoundException e){
            System.out.println("File not found, please input a new file name.")
            return 0;
        }


        return 0;
    }


    public static void main(String[] args) {
        System.out.println("Hello, Sudoku!");
    }
}
